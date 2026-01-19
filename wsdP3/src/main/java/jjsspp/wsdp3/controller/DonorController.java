package jjsspp.wsdp3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jjsspp.wsdp3.bean.DonorVO;
import jjsspp.wsdp3.service.DonorService;

@Controller
@RequestMapping(value="/donor") // 기본 URL 경로 설정
public class DonorController {

	@Autowired
	DonorService donorService; // DAO 대신 Service 주입

	// 목록 조회 (검색 및 정렬 기능 포함)
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String donorList(Model model,
							@RequestParam(value="keyword", required=false) String keyword,
							@RequestParam(value="sort", required=false) String sort) {

		model.addAttribute("list", donorService.getDonorList(keyword, sort));
		return "list"; // list.jsp로 이동
	}

	// 추가 폼 이동
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addPost() {
		return "addform"; // addform.jsp로 이동
	}

	// 데이터 추가 처리
	@RequestMapping(value = "/addok", method = RequestMethod.POST)
	public String addPostOK(DonorVO vo) {
		int i = donorService.insertDonor(vo);
		if(i == 0)
			System.out.println("데이터 추가 실패");
		else
			System.out.println("데이터 추가 성공!!!");
		return "redirect:list";
	}

	// 수정 폼 이동
	@RequestMapping(value = "/editform", method = RequestMethod.GET)
	public String editPost(@RequestParam("id") int sid, Model model) {
		DonorVO vo = donorService.getDonor(sid);
		model.addAttribute("u", vo);
		return "editform"; // editform.jsp로 이동
	}

	// 데이터 수정 처리
	@RequestMapping(value = "/editok", method = RequestMethod.POST)
	public String editPostOK(DonorVO vo) {
		int i = donorService.updateDonor(vo);
		if(i == 0)
			System.out.println("데이터 수정 실패");
		else
			System.out.println("데이터 수정 성공!!!");
		return "redirect:list";
	}

	// 데이터 삭제 처리
	@RequestMapping(value = "/deleteok", method = RequestMethod.GET)
	public String deletePost(@RequestParam("id") int sid) {
		int i = donorService.deleteDonor(sid);
		if(i == 0)
			System.out.println("데이터 삭제 실패");
		else
			System.out.println("데이터 삭제 성공!!!");
		return "redirect:list";
	}
}