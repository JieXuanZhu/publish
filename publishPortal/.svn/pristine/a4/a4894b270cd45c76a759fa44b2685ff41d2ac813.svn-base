package cn.com.shukaiken.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.shukaiken.dao.IEditorDao;
import cn.com.shukaiken.model.Editor;
import cn.com.shukaiken.service.IEditorService;
@Service
public class EditorServiceImpl implements IEditorService {
	
	@Resource
	private IEditorDao editorDao;
	
	@Override
	public int addEditor(Editor editor) {
		return editorDao.insert(editor);
	}

	@Override
	public Editor getEditorById(int id) {
		return editorDao.selectByPrimaryKey(id);
	}

	@Override
	public Editor selectByEditor(Editor editor) {
		return editorDao.selectBySelective(editor);
	}

	@Override
	public List<Editor> getEditorLs(Editor editor) {
		return editorDao.getEditorLs(editor);
	}

	@Override
	public int updateByEditorId(Editor editor) {
		return editorDao.updateByPrimaryKeySelective(editor);
	}

	@Override
	public List<Editor> getEditorBySelectiveLs(Editor editor) {
		return editorDao.getEditorBySelectiveLs(editor);
	}
	
	

}
