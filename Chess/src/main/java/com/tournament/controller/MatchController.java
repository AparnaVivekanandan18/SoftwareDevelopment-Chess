package com.tournament.controller;
import com.chess.chessboard.Board;
import com.chess.chessboard.IBoard;
import com.tournament.model.Player;
import com.tournament.services.IMatchService;
import com.tournament.services.MatchService;
import com.tournament.model.IMatch;
import com.tournament.model.Match;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class MatchController {

    Player player1 = new Player();
    Player player2 = new Player();
    IMatch iMatch = new Match(player1, player2);
    IBoard board = new Board();

    @RequestMapping(value = "/matchChess", method = {RequestMethod.POST})
    public String viewMatchChessPage(HttpServletRequest request, Model model) {

        String firstPlayerId = request.getParameter("firstPlayer");
        String secondPlayerId = request.getParameter("secondPlayer");
        iMatch.setPlayer1id(firstPlayerId);
        iMatch.setPlayer2id(secondPlayerId);

        IMatchService iMatchService= new MatchService();
        iMatchService.saveMatch(iMatch);

        iMatch.createBoard();
        board = iMatch.getBoard();

        Map<String, String> piecePositions;
        piecePositions = iMatch.getBoard().getPositions();
        model.addAttribute("positions", piecePositions);

        return "MatchChess";
    }

    @RequestMapping(value = "/handleChessMove", method = {RequestMethod.POST})
    public String handleChessMove(HttpServletRequest request, Model model) {

        String inputX = request.getParameter("inputX");
        String inputY = request.getParameter("inputY");

        int clickX = Integer.parseInt(inputX);
        int clickY = Integer.parseInt(inputY);

        board.chessMovement(clickX, clickY);

        Map<String, String> piecePositions;
        piecePositions = iMatch.getBoard().getPositions();
        model.addAttribute("positions", piecePositions);
        model.addAttribute("activePiece", board.getActivePieceFilePath());
        model.addAttribute("kingCheck", board.isKingInCheck());

        return "MatchChess";
    }

}
