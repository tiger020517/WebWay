package jjsspp.wsdp3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jjsspp.wsdp3.bean.DonorVO;
import jjsspp.wsdp3.dao.DonorDAO;
import java.util.List;


@Service
public class DonorServiceImpl implements DonorService {

	@Autowired
	DonorDAO donorDAO;

	@Override
	public int insertDonor(DonorVO vo) {
		return donorDAO.insertDonor(vo);
	}

	@Override
	public int deleteDonor(int sid) {
		return donorDAO.deleteDonor(sid);
	}

	@Override
	public int updateDonor(DonorVO vo) {
		return donorDAO.updateDonor(vo);
	}

	@Override
	public DonorVO getDonor(int sid) {
		return donorDAO.getDonor(sid);
	}

	@Override
	public List<DonorVO> getDonorList(String keyword, String sort) {
		// ✅ 에러 해결: 인자 2개를 DAO로 전달
		return donorDAO.getDonorList(keyword, sort);
	}
}