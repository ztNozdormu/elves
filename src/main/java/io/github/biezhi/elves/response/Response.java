package io.github.biezhi.elves.response;

import io.github.biezhi.elves.request.Request;
import lombok.Getter;

import java.io.InputStream;

/**
 * 响应对象
 *
 * @author biezhi
 * @date 2018/1/11
 */
public class Response {

    @Getter
    private Request request;
    private Body    body;

    public Response(Request request, InputStream inputStream) {
        this.request = request;
        this.body = new Body(inputStream, request.charset());
    }

    public Body body() {
        return body;
    }

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

}
