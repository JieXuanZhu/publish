package cn.com.shukaiken.util;



public class Constant {
	/**
	 * session过期时间
	 */
	public static final Integer SESSION_VAL = 3600;

    /**
     * 防止重复提交令牌名
     */
    public static String DEFAULT_TOKEN_NAME = "springMVC.token";
    
    /**
     * 后台当前登录用户
     */
    public static String CURRENT_USER = "currentUser";
    
    public static String CURRENT_FRONT_USER = "current_frontUser";
    
    
    /**
     * 后台菜单的根节点
     */
    public static Integer TREE_ROOT_ID = 1;
    
    /**
     * 当前选中的父级菜单id存放name
     */
	public static final String CUR_MENU_PIDKEY = "menu_pid";
	
	
	/**
	 * 分页尺寸为10
	 */
	public static final Integer PAGE_SIZE_TEN = 10;

	
	 /**
	  * 新闻未生效
	  */
    public static Integer NEWS_STAGE_UNEFF = 0;
    /**
     * 新闻生效
     */
    public static Integer NEW_STAGE_EFF = 1;
    
    //数据有效状态定义
    /**
     * 有效
     */
    public static String VALID="0";
    /**
     * 无效
     */
    public static String INVALID="1";
    /**
     * 删除
     */
    public static String DELETED="2";
    
    //新闻来源定义
    
    /**
     * 新闻来源，后台添加
     */
    public static final String INFO_ORIGIN_BACKEND = "back";
    
    /**
     * 资讯来源，前端添加
     */
    public static final String INFO_ORIGIN_FRONT="front";
    
    /**
     * 资讯来源，网上抓取
     */
    public static final String INFO_ORIGIN_EXTRACTOR="extractor";

    /**
     * 判断是否，是
     */
	public static final String YES = "0";
	
	/**
	 * 判断是否，否
	 */
	public static final String NO = "1";
	
	//资讯状态
	/**
	 * 资讯状态，草稿
	 */
	public static final String INFO_STATUS_DRAFT = "1101-1";
	/**
	 * 资讯状态：已保存，待确认
	 */
	public static final String INFO_STATUS_UNCHECKED = "1101-2";
	/**
	 * 待审核阶段
	 */
	public static final String INFO_STATUS_WAIT_FIRST_CHECK = "1102-1";
	
	/**
	 * 资讯审核，第一阶段审核失败
	 */
	public static final String INFO_STATUS_FIRST_CHECK_FAIL = "1102-2";
	
	/**
	 * 资讯审核，待第二阶段审核
	 */
	public static final String INFO_STATUS_WAIT_SECOND_CHECK = "1102-3";
	
	/**
	 * 资讯审核，第二阶段审核失败
	 */
	public static final String INFO_STATUS_SECOND_CHECK_FAIL = "1102-4";
	
	/**
	 * 资讯审核，审核成功，未发布
	 */
	public static final String INFO_STATUS_CHECK_SUCCESS = "1102-5";
	
	/**
	 * @Fields INFO_STATUS_CHECK_WAIT_PUBLISH : <p> TODO 资讯待发布</p>
	 */
	public static final String INFO_STATUS_CHECK_WAIT_PUBLISH="1102-6";
	
	/**
	 * 待发布，需要首页编排
	 */
	public static final String INFO_STATUS_CHECK_PUBLISH_WAIT_REWRITE="1102-7";
	
	/**
	 * 首页编排完成,待发布审核
	 */
	public static final String INFO_STATUS_CHECK_REWRITE_COMPLETE="1102-8";
	/**
	 * 资讯发布成功
	 */
	public static final String INFO_STATUS_PUBLISH = "1103-1";
	
	/**
	 * 资讯发布撤回，不展示
	 */
	public static final String INFO_STATUS_PUBLISH_ROLLBACK = "1103-2";
	
	
	public static final String MODULE_NEWINFO="newsinfo";
	
	public static final String MODULE_CRAWLNEWS = "crawlnews";
}
