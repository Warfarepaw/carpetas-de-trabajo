package com.JGallardo.empleos.security;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//
//@Configuration
//@EnableWebSecurity
//public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter{
public class DatabaseWebSecurity{
	
//	
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() 
//	{
//		BCryptPasswordEncoder bCPE = new BCryptPasswordEncoder();
//		
//		return bCPE;
//	}
	
//	@Autowired
//	private DataSource dataSource;
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception
//	{
//		auth.jdbcAuthentication().dataSource(dataSource)
//		.usersByUsernameQuery("select nombre, password, estatus from Usuarios where nombre=?")
//		.authoritiesByUsernameQuery("select up.idUsuario, up.idPerfil, u.nombre From UsuarioPerfil  up "
//				+ "inner join Usuarios u on u.idUsuario = up.idUsuario "
//				+ "inner join Perfiles p on p.idPerfil=up.idPerfil where u.nombre = 'Jesus Gallardo'");
//	}
	
}
