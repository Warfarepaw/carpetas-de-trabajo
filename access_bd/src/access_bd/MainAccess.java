package access_bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;

public class MainAccess {

	public static void main(String[] args) {

		ArrayList<productPojo> listaProductos = new ArrayList<productPojo>();

		productPojo nuevoProducto = new productPojo();

		nuevoProducto.setNombre("tenis nuevos");
		nuevoProducto.setCategoria("categoriaNueva");
		nuevoProducto.setColor("colorNuevo");
		nuevoProducto.setTalla(8);
		nuevoProducto.setDescription("Hombre");
		nuevoProducto.setPrecio(20);
		nuevoProducto.setCantidad(12);
		nuevoProducto.setImg("1");

//		listaProductos = borrarProducto(1);
//		listaProductos = agregarProducto(nuevoProducto);
//		listaProductos = selectOneProduct(120);
//		listaProductos = modificarProducto(150, nuevoProducto);
//		listaProductos = consultarProducto();

	}

	public static ArrayList<productPojo> consultarProducto() {

		String consultaTodos = "SELECT * FROM productos";
		ArrayList<productPojo> listaProductos = new ArrayList<productPojo>();
		listaProductos = Conexion(consultaTodos, null, 0);
		return listaProductos;
	}

	public static ArrayList<productPojo> selectOneProduct(int idProducto) {

		String consultaTodos = "SELECT * FROM productos WHERE Id_Producto = ? ";
		ArrayList<productPojo> listaProductos = new ArrayList<productPojo>();
		listaProductos = Conexion(consultaTodos, null, idProducto);
		return listaProductos;
	}

	public static ArrayList<productPojo> borrarProducto(int idProducto) {

		String delete = "DELETE FROM productos WHERE Id_Producto = ?";
		ArrayList<productPojo> listaProductos = new ArrayList<productPojo>();
		listaProductos = Conexion(delete, null, idProducto);
		return listaProductos;
	}

	public static ArrayList<productPojo> modificarProducto(int idProducto, productPojo nuevoProducto) {

		String update = "UPDATE productos SET nombre = ?, categoria = ?, color= ?, talla = ?, descripcion = ?, precio = ?, cantidad = ?, imagen = ? where Id_Producto = ?";
		ArrayList<productPojo> listaProductos = new ArrayList<productPojo>();
		listaProductos = Conexion(update, nuevoProducto, idProducto);
		return listaProductos;
	}

	public static ArrayList<productPojo> agregarProducto(productPojo nuevoProducto) {

		int idNuevo = consultarProducto().size() + 10;
		nuevoProducto.setIdProducto(idNuevo);

		String add = "INSERT INTO productos(Id_Producto, nombre, categoria, color, talla, descripcion, precio, cantidad, imagen) VALUES (?,?,?,?,?,?,?,?,?)";
		ArrayList<productPojo> listaProductos = new ArrayList<productPojo>();
		listaProductos = Conexion(add, nuevoProducto, 0);
		return listaProductos;
	}

	public static ArrayList<productPojo> Conexion(String query, productPojo nuevoProducto, int IdProducto) {
		String databaseURL = "jdbc:ucanaccess://Database22 _terminada.accdb"; // ruta relativa al archivo de base de
																				// datos
		ArrayList<productPojo> listaProductos = new ArrayList<productPojo>();
		try {
			Connection connection = DriverManager.getConnection(databaseURL);
			ResultSet result = null;
			System.out.println("Connected to MS Access database.");

			if (nuevoProducto != null) {
				PreparedStatement preSttmnt = connection.prepareStatement(query);

				if (query.contains("INSERT INTO")) {
					preSttmnt = connection.prepareStatement(query);

					preSttmnt.setInt(1, nuevoProducto.getIdProducto());
					preSttmnt.setString(2, nuevoProducto.getNombre());
					preSttmnt.setString(3, nuevoProducto.getCategoria());
					preSttmnt.setString(4, nuevoProducto.getColor());
					preSttmnt.setInt(5, nuevoProducto.getTalla());
					preSttmnt.setString(6, nuevoProducto.getDescription());
					preSttmnt.setInt(7, nuevoProducto.getPrecio());
					preSttmnt.setInt(8, nuevoProducto.getCantidad());
					preSttmnt.setString(9, nuevoProducto.getImg());

				}

				if (query.contains("UPDATE")) {
					preSttmnt = connection.prepareStatement(query);
					preSttmnt.setString(1, nuevoProducto.getNombre());
					preSttmnt.setString(2, nuevoProducto.getCategoria());
					preSttmnt.setString(3, nuevoProducto.getColor());
					preSttmnt.setInt(4, nuevoProducto.getTalla());
					preSttmnt.setString(5, nuevoProducto.getDescription());
					preSttmnt.setInt(6, nuevoProducto.getPrecio());
					preSttmnt.setInt(7, nuevoProducto.getCantidad());
					preSttmnt.setString(8, nuevoProducto.getImg());

				}

				System.out.println("codigo de ejecucion de base de datos: " + preSttmnt.executeUpdate());

			} else {

				if (query.contains("SELECT * FROM productos") && (IdProducto == 0) ) {
					Statement statement = connection.createStatement();
					
					result = statement.executeQuery(query);

					while (result.next()) {

						productPojo producto = new productPojo(); // este es el objeto que va a contener la informacion
																	// de
																	// cada
																	// fila en la base de datos
						// es la otra clase plain old java object
						int idProducto = result.getInt("Id_Producto");
						String nombre = result.getString("nombre");
						String categoria = result.getString("categoria");
						String color = result.getString("color");
						int talla = result.getInt("talla");
						String descripcion = result.getString("precio");
						int cantidad = result.getInt("cantidad");
						// String img = result.getString("foto");

						producto.setIdProducto(idProducto);
						producto.setNombre(nombre);
						producto.setCategoria(categoria);
						producto.setColor(color);
						producto.setTalla(talla);
						producto.setDescription(descripcion);
						producto.setCantidad(cantidad);
						// producto.setimg(img);

						listaProductos.add(producto); // este es el archivo que va a contener la lista de productos
						System.out.println(idProducto + " " + nombre + " " + categoria + " " + color + " " + talla + " "
								+ descripcion + " " + cantidad);
					}

				}

				if (query.contains("DELETE FROM")) {
					PreparedStatement preSttmnt = connection.prepareStatement(query);
					preSttmnt.setInt(1, IdProducto);
					System.out.println("codigo de ejecucion de base de datos: " + preSttmnt.executeUpdate());
				}

				if (query.contains("SELECT * FROM productos WHERE") && IdProducto != 0) {
					PreparedStatement preSttmnt = connection.prepareStatement(query);
					preSttmnt.setInt(1, IdProducto);
					result = preSttmnt.executeQuery();
					
					while (result.next()) {

						productPojo producto = new productPojo(); // este es el objeto que va a contener la informacion
																	// de
																	// cada
																	// fila en la base de datos
						// es la otra clase plain old java object
						int idProducto = result.getInt("Id_Producto");
						String nombre = result.getString("nombre");
						String categoria = result.getString("categoria");
						String color = result.getString("color");
						int talla = result.getInt("talla");
						String descripcion = result.getString("precio");
						int cantidad = result.getInt("cantidad");
						// String img = result.getString("foto");

						producto.setIdProducto(idProducto);
						producto.setNombre(nombre);
						producto.setCategoria(categoria);
						producto.setColor(color);
						producto.setTalla(talla);
						producto.setDescription(descripcion);
						producto.setCantidad(cantidad);
						// producto.setimg(img);

						listaProductos.add(producto); // este es el archivo que va a contener la lista de productos
						System.out.println(idProducto + " " + nombre + " " + categoria + " " + color + " " + talla + " "
								+ descripcion + " " + cantidad);
					}
					//System.out.println("codigo de ejecucion de base de datos: " + preSttmnt.executeUpdate());
				}

			}

			connection.close();

			return listaProductos;
		} catch (SQLException e) {
			System.out.println(
					"Error al momento de conectarse a la base de datos, detalles del error:  " + e.getMessage());
			return null;
		}
	}

}
