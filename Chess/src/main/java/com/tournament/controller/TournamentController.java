package com.tournament.controller;

import com.tournament.model.ILeaderboard;
import com.tournament.model.Leaderboard;
import com.tournament.model.Player;
import com.tournament.model.StartTournament;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TournamentController {

    @RequestMapping("/tournament")
    public String viewTournamentPage()
    {
        return "Tournament";
    }

    @RequestMapping(value = "/viewLeaderboard", method = {RequestMethod.POST})
    public String viewLeaderboardChessPage(HttpServletRequest request, Model model) {

        String tournamentId = request.getParameter("tournamentId");

        ILeaderboard leaderboard= new Leaderboard();
        List<Player> players = leaderboard.getLeaderboard(Integer.parseInt(tournamentId));

        model.addAttribute("players", players);

        return "Tournament";
    }

    @RequestMapping("/startTournament")
    public String startTournamentPage()
    {
        StartTournament startTournament = new StartTournament();
        startTournament.initialise();

        return "Tournament";
    }
}