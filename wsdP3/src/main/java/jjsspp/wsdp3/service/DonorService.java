package jjsspp.wsdp3.service;

import jjsspp.wsdp3.bean.DonorVO;
import java.util.List;

public interface DonorService {
	int insertDonor(DonorVO vo);
	int deleteDonor(int sid);
	int updateDonor(DonorVO vo);
	DonorVO getDonor(int sid);

	// 검색과 정렬을 위해 인자 2개를 받도록 설정
	List<DonorVO> getDonorList(String keyword, String sort);
}