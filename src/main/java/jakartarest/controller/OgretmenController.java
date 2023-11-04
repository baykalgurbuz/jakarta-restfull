package jakartarest.controller;
import java.util.ArrayList;

import com.bilgeadam.postgresqljdbc.model.Ogretmen;
import com.bilgeadam.postgresqljdbc.repository.OgretmenRepository;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
 
 
 

@Path(value = "/ogretmen")
public class OgretmenController {
private static OgretmenRepository ogretmen_repo=new OgretmenRepository();
	@GET
	@Path(value = "/get")
	public String print() {
		return "GET. ";
	}
	@GET
	@Path(value = "/listall")
	@Produces(value=MediaType.APPLICATION_JSON)
	public Response getall() {
		try { 
			ArrayList<Ogretmen> result =ogretmen_repo.getAll();
			System.err.println(result);
			return Response.ok().entity(result).build();		
			} catch (Exception e) {
			return Response.serverError().entity("Bir hata olustu").build();
		}
		
	}
	@POST
	@Path(value = "/save")
	@Consumes(value=MediaType.APPLICATION_JSON)
	public Response save(Ogretmen ogretmen)
	{
		try {
			if (ogretmen_repo.save(ogretmen)) {
				return Response.status(Status.CREATED).entity("KAYIT OLUNDU").build();
			}
			else
			{
				return Response.serverError().entity("OLMADI").build();
			}
		} catch (Exception e) {
			// TODO: handle exception
			return Response.serverError().entity("HATA"+e.getClass()).build();
		}
	}
	@DELETE
	@Path(value = "/deletebyid/{id}")
	@Produces(value = MediaType.TEXT_PLAIN)
	public Response deletebyid(@PathParam(value = "id") long id)
	{
		// localhost:8080/jakartarest/ogretmen/deletebyid/1
		try
		{
			if (ogretmen_repo.deleteByID(id))
			{
				return Response.ok().entity("Başarı ile silindi").build();
			}
			else
			{
				return Response.status(Status.NOT_FOUND).entity("Kayıt bulunamadı").build();
			}
		}
		catch (Exception e)
		{
			return Response.serverError().entity("Bir hata oluştu -> " + e.getClass()).build();
		}
	}
	@GET
	@Path(value = "/getbyid/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getbyidpath(@PathParam(value = "id") long id)
	{
		// localhost:8080/jakartarest/ogretmen/getbyid/1
		try
		{
			Ogretmen result = ogretmen_repo.getByID(id);
			if (result == null)
			{
				return Response.status(Status.NOT_FOUND).entity("Kayıt bulunamadı").build();
			}
			else
			{
				return Response.ok().entity(result).build();
			}
		}
		catch (Exception e)
		{
			return Response.serverError().entity("Bir hata oluştu -> " + e.getClass()).build();
		}
	}
	@GET
	@Path(value = "/getbyid")
	@Produces(value=MediaType.APPLICATION_JSON)
	public Response getbyid(@QueryParam(value="id") long id) {

		// 1-? işareti query parameter 
		// 2-/ ile verilen path parameter
		// 3- header
		try { 
			 Ogretmen  result =ogretmen_repo.getByID(id);
			return Response.ok().entity(result).build();		
			} catch (Exception e) {
			return Response.serverError().entity("Bir hata olustu").build();
		}
		
	}
}
