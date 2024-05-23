package com.example.springbhootcrudapp.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	
	private int customerId;
	
	@NotBlank(message = "customerName is mandatory")
    @Size(min = 6, message = "customerName must be at min lenght  6 characters only ")
	@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name can only contain letters and spaces")
	private String customerName;
	
	
	
	@NotBlank(message = "customerName is mandatory")
	@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name can only contain letters and spaces")
	private String customeraddreess;
	
	   @Size(min = 10, max=10 ,message = "customerName must be at least 10 characters long")
	@Pattern(regexp ="^[0-9]{10}$",message="contact should only numbers no afhabets neither special characters")
	private String customerContact;
	

}
