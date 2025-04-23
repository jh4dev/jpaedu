package com.example.resttest.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@Controller
public class UserController {


	@GetMapping("/")
	@Cacheable(value = "homeCache", key = "'home'")
	@Async
	public CompletableFuture<String> index( Model model) {
		return CompletableFuture.completedFuture("index");
	}

	@GetMapping("/test")
	public String test( Model model) {
		return "test";
	}

	@GetMapping("/form")
	public String form( Model model) {
		return "form";
	}

	@GetMapping("/personview")
	public String personview( Model model) {
		return "personview";
	}

	@GetMapping("/insert")
	public String insert( Model model) {
		return "insert";
	}

	@GetMapping("/update")
	public String update( Model model) {
		return "update";
	}

	@GetMapping("/delete")
	public String delete( Model model) {
		return "delete";
	}
	@GetMapping("/order")
	public String order( Model model) {
		return "order";
	}

    //server.compression.min-response-size=1KB 1KB 이상일 때만 압축
    // f12 네트워크에서 수신 json 클릭후 헤더에 gzip 압축 확인

    @GetMapping("/large-json")
    @ResponseBody
    public List<Map<String, Object>> getLargeJson() {
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", i);
            map.put("name", "User_" + i);
            map.put("description", "이건 매우 긴 설명입니다. 데이터를 반복해서 길게 만들어서 gzip 압축 테스트를 해보겠습니다. ".repeat(5));
            list.add(map);
        }
        return list;
    }

    @GetMapping("/stream")
    @ResponseBody
    public ResponseEntity<StreamingResponseBody> streamData() {

        StreamingResponseBody stream = outputStream -> {
            // 스트리밍 데이터 처리
            for (int i = 0; i < 1000; i++) {
                outputStream.write(("Data " + i + "\n").getBytes());
                outputStream.flush();  //바로 전송
                //Thread.sleep(100);
            }
        };

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);

        return ResponseEntity.ok()
                .headers(headers)
                .body(stream);
    }

}




