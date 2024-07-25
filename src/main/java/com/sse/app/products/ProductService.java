package com.sse.app.products;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sse.app.files.FileManager;
import com.sse.app.members.MemberDTO;
import com.sse.app.util.Pager;
import com.sse.app.util.ProductCommentPager;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private FileManager fileManager;

	public List<ProductDTO> getList(Pager pager) throws Exception {

		pager.makeRow();
		Long totalCount = productDAO.getTotalCount(pager);

		pager.makeNum(totalCount);

		return productDAO.getList(pager);

	}

	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {

		return productDAO.getDeatil(productDTO);

	}

	public int addInfo(ProductDTO productDTO, MultipartFile[] files, HttpSession session) throws Exception {

		Integer num = productDAO.getNum();
		productDTO.setItem_id(num);

		int result = productDAO.addInfo(productDTO);

		if (files == null) {
			return result;
		}

//		1.파일을 저장할 위치를 지정
		ServletContext servletContext = session.getServletContext();
		String path = servletContext.getRealPath("resources/upload/products");
		System.out.println(path);

//		2.저장할 파일명 생성
		for (MultipartFile f : files) {
			if (f.isEmpty()) {
				continue;
			}

			String fileName = fileManager.fileSave(f, path);

//		4. 파일정보를 DB에 저장
			ProductFileDTO productFileDTO = new ProductFileDTO();
			productFileDTO.setFileName(fileName);
			productFileDTO.setOriName(f.getOriginalFilename());
			productFileDTO.setItem_id(num);
			result = productDAO.addFile(productFileDTO);
		}

		return result;

	}

	public int deleteInfo(ProductDTO productDTO) {
		return productDAO.deleteInfo(productDTO);
	}

	public int updateInfo(ProductDTO productDTO) {

		return productDAO.updateInfo(productDTO);

	}

	public int addWish(Integer item_id, String member_id) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("item_id", item_id);
		map.put("member_id", member_id);

		return productDAO.addWish(map);

	}

	public List<ProductDTO> wishList(MemberDTO memberDTO) throws Exception {
		return productDAO.wishList(memberDTO);
	}

	public int deleteWishList(Integer[] item_id, String member_id) throws Exception {

		int result = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("member_id", member_id);
		map.put("item_id", item_id);
		result = productDAO.deleteWishList(map);

		return result;
	}

	public int addComments(ProductCommentDTO productCommentDTO) throws Exception {
		return productDAO.addComments(productCommentDTO);
	}

	public List<ProductCommentDTO> commentList(ProductCommentPager productCommentPager) throws Exception {

		productCommentPager.makeRow();
		productCommentPager.makeNum(productDAO.commentTotalCount(productCommentPager));
		return productDAO.commentList(productCommentPager);

	}

	public int deleteComment(ProductCommentDTO productCommentDTO) throws Exception {
		return productDAO.deleteComment(productCommentDTO);
	}
}
