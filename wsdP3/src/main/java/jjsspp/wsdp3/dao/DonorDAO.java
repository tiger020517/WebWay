package jjsspp.wsdp3.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jjsspp.wsdp3.bean.DonorVO;

@Repository
public class DonorDAO {

	@Autowired
	SqlSession sqlSession;

	public int insertDonor(DonorVO vo) {
		return sqlSession.insert("Donor.insertDonor", vo);
	}

	public int updateDonor(DonorVO vo) {
		return sqlSession.update("Donor.updateDonor", vo);
	}

	public int deleteDonor(int sid) {
		return sqlSession.delete("Donor.deleteDonor", sid);
	}

	public DonorVO getDonor(int sid) {
		return sqlSession.selectOne("Donor.getDonor", sid);
	}

	// ✅ 수정된 부분: 두 개의 인자를 Map에 담아 Mapper로 전달
	public List<DonorVO> getDonorList(String keyword, String sort) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("keyword", keyword);
		map.put("sort", sort);

		return sqlSession.selectList("Donor.getDonorList", map);
	}
}