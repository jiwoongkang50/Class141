package com.shop.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.dto.ItemDto;

@Controller
@RequestMapping(value = "/thymeleaf")
public class ThymeleafController {

	@GetMapping(value="/th01")
	public String thymeleafEx01(Model model) {
		model.addAttribute("data","타임리프 예제01");
		System.out.println();
		return "thymeleaf/thymeleaf01";
	}
	
    @GetMapping(value = "/th02")
    public String thymeleafEx02(Model model){
        ItemDto itemDto = new ItemDto();
        itemDto.setItemDetail("상품 상세 설명");
        itemDto.setItemNm("테스트 상품1");
        itemDto.setPrice(10000);
        itemDto.setRegTime(LocalDateTime.now());

        model.addAttribute("itemDto", itemDto);
        return "thymeleaf/thymeleaf02";
    }
    
    @GetMapping(value = "/th03")
    public String thymeleafEx03(Model model) {
    	List<ItemDto> itemList = new ArrayList<>();
    	for(int i=1;i<=10;i++) {
    		ItemDto itemDto = new ItemDto();
            itemDto.setItemDetail("상품 상세 설명"+i);
            itemDto.setItemNm("테스트 상품"+i);
            itemDto.setPrice(1000*i);
            itemDto.setRegTime(LocalDateTime.now());
            itemList.add(itemDto);
    	}
    	model.addAttribute("itemDtoList",itemList);
    	return "thymeleaf/thymeleaf03";
    }
    
    @GetMapping(value = "/th04")
    public String thymeleafEx04() {
    	return "thymeleaf/thymeleaf04";
    }
    
    @GetMapping("/th05")
    public String thymeleafEx05(String param1,String param2,Model model) {
    	model.addAttribute("param1",param1);
    	model.addAttribute("param2",param2);
    	return "thymeleaf/thymeleaf05";
    }
    
    @GetMapping(value = "/th06")
    public String thymeleafEx06() {
    	return "thymeleaf/thymeleaf06";
    }
}
