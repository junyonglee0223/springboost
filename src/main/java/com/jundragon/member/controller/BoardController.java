package com.jundragon.member.controller;


import com.jundragon.member.dto.BoardDTO;
import com.jundragon.member.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;
import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/bsave")
    public String saveForm(){
        return "bsave";
    }

    @PostMapping("/bsave")
    public String save(@ModelAttribute BoardDTO boardDTO){
        System.out.println("boardDTO = " + boardDTO);
        boardService.save(boardDTO);
        return "redirect:/board/";
    }

    @GetMapping("/blist")
    public String findAll(Model model){
        List<BoardDTO> boardTOList = boardService.findAll();
        model.addAttribute("boardList", boardTOList);
        return "blist";

    }


}
