package com.jundragon.member.controller;


import com.jundragon.member.dto.BoardDTO;
import com.jundragon.member.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("/")
    public String findAll(Model model){
        List<BoardDTO> boardTOList = boardService.findAll();
        model.addAttribute("boardList", boardTOList);
        return "blist";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model){

        boardService.updateHits(id);
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "bdetail";
    }

    @GetMapping("/bupdate/{id}")
    public String updateForm(@PathVariable Long id, Model model){
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("boardUpdate", boardDTO);
        return "bupdate";
    }

    @PostMapping("/bupdate")
    public String update(@ModelAttribute BoardDTO boardDTO, Model model){
        BoardDTO board = boardService.update(boardDTO);
        model.addAttribute("board", board);
        return "bdetail";
//        return "redirect:/board/" + boardDTO.getId();
    }


}
