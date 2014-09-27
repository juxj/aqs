package com.lh.appasync.dao;

import java.util.Map;

import com.lh.appasync.model.po.Composition;

public interface ICompositionDAO extends IBaseDAO <Composition, String> {

	/**
     * 更新评论数
     * @param query
     * @param param
     */
    public void updateCommentCount(String query,Map<String, Object> param);
}
