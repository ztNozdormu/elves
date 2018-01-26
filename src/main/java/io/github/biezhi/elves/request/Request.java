package io.github.biezhi.elves.request;

import io.github.biezhi.elves.spider.Spider;
import lombok.Getter;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * Request 请求
 *
 * @author biezhi
 * @date 2018/1/11
 */
@Getter
public class Request<T> {

    private Spider spider;
    private String url;
    private String              method  = "GET";
    private Map<String, String> headers = new HashMap<>();
    private Map<String, String> cookies = new HashMap<>();
    private String contentType = "text/html; charset=UTF-8";
    private String charset = "UTF-8";
    private Parser<T> parser;

    public Request(Spider spider, String url, Parser<T> parser) {
        this.spider = spider;
        this.url = url;
        this.parser = parser;
        this.header("User-Agent", spider.getConfig().userAgent());
    }

    public Request header(String key, String value) {
        this.headers.put(key, value);
        return this;
    }

    public Request cookie(String key, String value) {
        this.cookies.put(key, value);
        return this;
    }

    public String header(String key) {
        return this.headers.get(key);
    }

    public String cookie(String key) {
        return this.cookies.get(key);
    }

    public void setParser(Parser<T> parser) {
        this.parser = parser;
    }

    public String contentType() {
        return contentType;
    }

    public Request contentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    public String charset() {
        return charset;
    }

    public Request charset(String charset) {
        this.charset = charset;
        return this;
    }

    public Request method(String method) {
        this.method = method;
        return this;
    }

    public String method() {
        return this.method;
    }

	public Spider getSpider() {
		return spider;
	}

	public void setSpider(Spider spider) {
		this.spider = spider;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public Map<String, String> getCookies() {
		return cookies;
	}

	public void setCookies(Map<String, String> cookies) {
		this.cookies = cookies;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public Parser<T> getParser() {
		return parser;
	}
    
}
