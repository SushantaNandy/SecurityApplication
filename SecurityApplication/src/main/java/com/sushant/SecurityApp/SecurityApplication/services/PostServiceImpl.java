package com.sushant.SecurityApp.SecurityApplication.services;

import com.sushant.SecurityApp.SecurityApplication.dto.PostDTO;
import com.sushant.SecurityApp.SecurityApplication.entities.PostEntity;
import com.sushant.SecurityApp.SecurityApplication.exception.ResourceNotFoundException;
import com.sushant.SecurityApp.SecurityApplication.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<PostDTO> getAllPosts() {
        return postRepository.findAll().
                stream().
                map(postEntity -> modelMapper.map(postEntity, PostDTO.class)).
                collect(Collectors.toList());
    }

    @Override
    public PostDTO createNewPost(PostDTO inputPost) {
        PostEntity postEntity = modelMapper.map(inputPost, PostEntity.class);
        return modelMapper.map(postRepository.save(postEntity), PostDTO.class);
    }

    @Override
    public PostDTO getPostById(Long postId) {
        PostEntity postEntity = postRepository.
                findById(postId).
                orElseThrow(()->new ResourceNotFoundException("Post Not Found By ID "+ postId));
        return modelMapper.map(postEntity, PostDTO.class);
    }

    @Override
    public PostDTO updatePost(PostDTO inputPost, Long postId) {
        PostEntity olderPost = postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post Not Found By ID "+ postId));
        inputPost.setId(String.valueOf(postId));
        modelMapper.map(inputPost, olderPost);
        PostEntity savedPostEntity= postRepository.save(olderPost);
        return modelMapper.map(savedPostEntity, PostDTO.class);
    }



}
