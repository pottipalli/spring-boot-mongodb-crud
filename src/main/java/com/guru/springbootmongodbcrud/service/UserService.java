package com.guru.springbootmongodbcrud.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.springbootmongodbcrud.dto.UserDTO;
import com.guru.springbootmongodbcrud.model.User;
import com.guru.springbootmongodbcrud.repo.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<UserDTO> getUserList() {
		return userRepository.findAll().stream().map(u -> {
			UserDTO vo = new UserDTO();
			vo.setId(u.getId());
			vo.setName(u.getName());
			vo.setEmail(u.getEmail());
			return vo;
		}).collect(Collectors.toList());
	}

	public UserDTO getUserById(String id) {
		return userRepository.findById(id).map(u -> {
			UserDTO vo = new UserDTO();
			vo.setId(u.getId());
			vo.setName(u.getName());
			vo.setEmail(u.getEmail());
			return vo;
		}).orElse(null);
	}

	public void saveUser(UserDTO vo) {
		User user = new User();
		user.setName(vo.getName());
		user.setEmail(vo.getEmail());
		user.setPwd(vo.getPwd());
		userRepository.save(user);
	}

	public void updateUser(UserDTO vo) {
		User user = new User();
		user.setId(vo.getId());
		user.setName(vo.getName());
		user.setEmail(vo.getEmail());
		user.setPwd(vo.getPwd());
		userRepository.save(user);
	}

	public void deleteUser(UserDTO vo) {
		User user = new User();
		user.setId(vo.getId());
		userRepository.delete(user);
	}

}
