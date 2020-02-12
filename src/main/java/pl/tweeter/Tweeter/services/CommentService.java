package pl.tweeter.Tweeter.services;

import pl.tweeter.Tweeter.dtos.CommentDataDTO;

public interface CommentService {

    void addComment(CommentDataDTO commentDataDTO, Long id);
}
