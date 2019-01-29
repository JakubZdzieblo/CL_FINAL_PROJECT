package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Comment;
import pl.coderslab.repository.CommentRepository;

public class CommentConverter implements Converter<String, Comment> {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment convert(String s) {
        return commentRepository.findOne(Long.parseLong(s));
    }
}
