package com.lh.appasync.async;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.lh.appasync.service.ICompositionService;
import com.lh.appasync.service.IPlayerService;

/**
 * 更新评论数
 * @author peng
 *
 */
public class CommentMonitor extends Monitor {

    private static Logger _logger = LoggerFactory.getLogger(CommentMonitor.class);
    @Autowired
    private ICompositionService compositionService;
    @Autowired
    private IPlayerService playerService;
    
    public void setPlayerService(IPlayerService playerService) {
		this.playerService = playerService;
	}
    
    public void setCompositionService(ICompositionService compositionService) {
		this.compositionService = compositionService;
	}
    
    @SuppressWarnings("unchecked")
	@Override
    protected void execute(Object obj) {
        _logger.debug("comment monitor is executing.");
        if (obj == null)
        {
        	return;
        }
        // 更新评论数
        compositionService.updateCommentCount((Map<String, String>)obj);
    }

}