package com.devsuperior.aula.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.aula.dto.PersonDepartmentDTO;
import com.devsuperior.aula.entities.Department;
import com.devsuperior.aula.entities.Person;
import com.devsuperior.aula.repositories.DepartmentRepository;
import com.devsuperior.aula.repositories.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public PersonDepartmentDTO inserir(PersonDepartmentDTO dto) {
		Person entity = new Person();
		entity.setName(dto.getName());
		entity.setSalary(dto.getSalary());
		
		//nesse exemplo não retorna o nome do objeto, apenas cria um novo com as informações do json, no caso somente o id, sem nome, nao é um objeto monitorado pela jpa. entidade transiente(não gerenciada pela jpa)
		//Department dept = new Department()
		//dept.setId(dto.getDepartment().getId());
		
		
		//nesse exemplo retorna o objeto completo do id informado, porque está sendo obtido o id do banco. é uma entidade gerenciada, por isso trousse o objeto do departamento completo
		Department dept = departmentRepository.getReferenceById(dto.getDepartment().getId());
			
		
		entity.setDepartment(dept);
		
		entity = repository.save(entity);
		
		return new PersonDepartmentDTO(entity);		
		
	}

}
