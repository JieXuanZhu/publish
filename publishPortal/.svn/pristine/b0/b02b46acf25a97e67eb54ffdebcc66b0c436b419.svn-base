package cn.com.shukaiken.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.shukaiken.dao.IEditorImgDao;
import cn.com.shukaiken.model.EditorImg;
import cn.com.shukaiken.service.IEditorImgService;
@Service
public class EditorImgServiceImpl implements IEditorImgService {
	
	@Resource
	private IEditorImgDao editorImgDao;

	@Override
	public int addEditorImg(EditorImg editorImg) {
		return editorImgDao.insert(editorImg);
	}

	@Override
	public EditorImg getEditorImgById(int id) {
		return editorImgDao.selectByPrimaryKey(id);
	}

	@Override
	public EditorImg selectByEditorImg(EditorImg editorImg) {
		return editorImgDao.selectBySelective(editorImg);
	}

	@Override
	public List<EditorImg> getEditorImgLs(EditorImg editorImg) {
		return editorImgDao.getEditorImgLs(editorImg);
	}

	@Override
	public int updateByEditorImgId(EditorImg editorImg) {
		return editorImgDao.updateByPrimaryKeySelective(editorImg);
	}

}
