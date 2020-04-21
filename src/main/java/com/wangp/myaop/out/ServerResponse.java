package com.wangp.myaop.out;

public class ServerResponse {

    private String code;
    private String message;
    private Object payload;

    public ServerResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ServerResponse(ResponseEnum responseEnum, Object payload) {
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
        this.payload = payload;
    }
    public ServerResponse(String code, String message , Object payload) {
        this.code = code;
        this.message = message;
        this.payload = payload;
    }
    public ServerResponse() {
        this.code = ResponseEnum.SUCCESS.getCode();
        this.message = ResponseEnum.SUCCESS.getMessage();
    }

    /**
     * 新增静态方法
     * @param responseEnum
     * @return
     */
    public static ServerResponse errorResponse(ResponseEnum responseEnum) {
        return new ServerResponse(responseEnum.getCode(),responseEnum.getMessage());
    }
    public static ServerResponse errorResponse(ResponseEnum responseEnum,Object payload) {
        return new ServerResponse(responseEnum.getCode(),responseEnum.getMessage(),payload);
    }
    public static ServerResponse successResponse(ResponseEnum responseEnum) {
        return new ServerResponse(responseEnum.getCode(),responseEnum.getMessage());
    }
    public static ServerResponse successResponse(ResponseEnum responseEnum,Object payload) {
        return new ServerResponse(responseEnum.getCode(),responseEnum.getMessage(),payload);
    }

    public ServerResponse ok(ResponseEnum responseEnum, Object payload){
        return new ServerResponse(responseEnum, payload);
    }

    public ServerResponse ok(ResponseEnum responseEnum){

        return new ServerResponse().ok(responseEnum, null);
    }

    public ServerResponse error(ResponseEnum responseEnum, Object payload){

        return new ServerResponse(responseEnum, payload);
    }

    public ServerResponse error(ResponseEnum responseEnum){

        return new ServerResponse().error( responseEnum, null);
    }
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

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

}
