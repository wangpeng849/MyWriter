package com.wangp.myaop.out;

public enum ResponseEnum {

    SUCCESS("0", "操作成功"),
    FAILED("-1", "操作失败"),
    INSERTTAG_ERROR("410", "添加标签失败"),
    AccessDeniedException("413", "访问被拒绝"),
    INSERTARTICLE_ERROR("414", "添加文章失败"),
    //缺少Servlet请求参数异常
    MISSINGSERVLETREQUESTPARAMETER("415","缺少Servlet请求参数,cloudId不能为空,无法正常调用接口"),
    ARTICLE_DOES_NOT_EXIST("423","文章不存在"),
    UPDATEARTICLE_ERROR("416", "更新文章失败"),
    REMOVEARTICLE_ERROR("417", "删除文章失败"),
	IMAGE_ERROR("418","文件上传失败"),
    Dim_STRREALCOUNT("419","文件最大上传量为5"),
    DELETE_FILE_ERROR("420", "文件删除失败"),
    FILE_DOES_NOT_EXIST("421", "文件不存在"),

    TEMPLATE_EXIST("401", "模板已存在"),
    TEMPLATE_NOT_EXIST("405", "模板不存在"),
    LOGIN_SUCCESS("402", "登陆成功"),
    LOGIN_FAILED("403", "登陆失败，请检查用户名和密码后再重试一遍"),
    NO_LOGIN_FAILED("406", "用户未登陆"),


    FILE_PATH_EXIST("407","文件路径不存在"),

    //字段配置
    CLEAN_DATA_FAIL("601","清空数据失败"),
    FIELD_ALREADY_EXIST("602","字段已存在"),
    FIELD_IS_EMPTY("603","字段名为空"),


    PARAM_IS_EMPTY ("701","参数为空"),
    PARAM_ERROR("702","参数错误");

    ResponseEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
