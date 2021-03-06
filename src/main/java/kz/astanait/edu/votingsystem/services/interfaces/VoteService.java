package kz.astanait.edu.votingsystem.services.interfaces;

import kz.astanait.edu.votingsystem.exceptions.VoteNotFoundException;
import kz.astanait.edu.votingsystem.models.Option;
import kz.astanait.edu.votingsystem.models.Question;
import kz.astanait.edu.votingsystem.models.User;
import kz.astanait.edu.votingsystem.models.Vote;

import java.util.List;

public interface VoteService extends GenericService<Vote> {

    Vote findVoteByUserAndOptionAndQuestion(User user, Option option, Question question) throws VoteNotFoundException;
    List<Vote> findTop5ByUserOrderByIdDesc(User user);
    List<Vote> findVotesByUser(User user);
    List<Vote> findVotesByQuestionAndOption(Question question, Option option);
    void deleteAllByOption(Option option);
    void deleteAllByQuestion(Question question);
}
