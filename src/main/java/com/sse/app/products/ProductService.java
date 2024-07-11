package com.sse.app.products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;

	public Map<String, Object> getList(Long page) throws Exception {

		if (page == null) {
			page = 1L;
		}

//		한 페이지에 몇개의 행을 보여주고 싶니
		long perPage = 10;

//		보여줄 시작행 번호와 끝나는행 번호를 SQL로 보내기 위한 작업
		long startRow = 1 + (perPage * (page - 1));
		long lastRow = page * perPage;

		List<Long> ar = new ArrayList<Long>();
		ar.add(startRow);
		ar.add(lastRow);

		List<ProductDTO> list = productDAO.getList(ar);

//		내가 가진 데이터의 총 갯수를 SQL에서 가져오는 작업
		long totalCount = productDAO.getTotalCount();
//		한 페이지에 10개씩 보여주면 총 몇개의 페이지가 나오니
		long totalPage = 0;

		if (totalCount % perPage != 0) {
			totalPage = totalCount / perPage + 1;
		} else {
			totalPage = totalCount / perPage;
		}

//		버튼 갯수 몇개 보여주고 싶니
//		totalPage
		long perBlock = 5;
		long totalBlock = 0;

//		그 5개씩 되는 버튼 뭉탱이가 몇개니
		if (totalPage % perBlock != 0) {
			totalBlock = totalPage / perBlock + 1;
		} else {
			totalBlock = totalPage / perBlock;
		}

//		지금 니가 이 페이지에 있는데 이 페이지는 몇번째 블럭 뭉탱이에 속하니
		long curBlock = 0;

		if (page % perBlock != 0) {
			curBlock = page / perBlock + 1;
		} else {
			curBlock = page / perBlock;
		}

//		지금 니가 있는 블럭 뭉탱이에서 첫번째는 몇페이지고, 마지막은 몇페이지니?
//		curBlock
		long start = 1 + (perBlock * (curBlock - 1));
		long end = curBlock * perBlock;

//		지금 니가 있는 블럭 뭉탱이 이전에 블럭이 또 존재하니? 또는 이후에 블럭이 또 존재하니?
		boolean pre = true;
		boolean after = true;

//		(맨 처음 블럭에서)전에 블럭이 없으면
		if (curBlock <= 1) {
			pre = false;
		}
//		(맨 마지막 블럭에서)후에 블럭이 없으면 (현재 내가 있는 블럭의 위치는 총 블럭수보다 커질 수 없다)
		if (curBlock == totalBlock) {
			after = false;
			end = totalPage;
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("start", start);
		map.put("end", end);
		map.put("pre", pre);
		map.put("after", after);

		return map;

	}

	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {

		return productDAO.getDeatil(productDTO);

	}

	public int addInfo(ProductDTO productDTO) throws Exception {

		return productDAO.addInfo(productDTO);

	}

	public int deleteInfo(ProductDTO productDTO) {
		return productDAO.deleteInfo(productDTO);
	}

	public int updateInfo(ProductDTO productDTO) {

		return productDAO.updateInfo(productDTO);

	}

}
