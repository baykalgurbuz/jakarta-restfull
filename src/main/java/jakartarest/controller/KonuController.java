package jakartarest.controller;

import java.util.ArrayList;
import com.bilgeadam.postgresqljdbc.model.Konu;
import com.bilgeadam.postgresqljdbc.repository.KonuRepository;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path(value = "/konu")
public class KonuController {
	private static KonuRepository konu_repo=new KonuRepository();
	@GET
	@Path(value = "/get")
	public String print() {
		return "GET. ";
	}
	@GET
	@Path(value = "/getall")
	@Produces(value=MediaType.APPLICATION_JSON)
	public Response getall() {
		try { 
			ArrayList<Konu> result =konu_repo.getAll();
			System.err.println(result);
			return Response.ok().entity(result).build();		
			} catch (Exception e) {
			return Response.serverError().entity("Bir hata olustu").build();
		}
		
	}
	@POST
	@Path(value = "/save")
	@Consumes(value=MediaType.APPLICATION_JSON)
	public Response save(Konu konu)
	{
		try {
			if (konu_repo.save(konu)) {
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
		// localhost:8080/JavaEx/konu/deletebyid/1
		try
		{
			if (konu_repo.deleteByID(id))
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
		// localhost:8080/JavaEx/konu/getbyid/1
		try
		{
			Konu result = konu_repo.getByID(id);
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
			 Konu  result =konu_repo.getByID(id);
			return Response.ok().entity(result).build();		
			} catch (Exception e) {
			return Response.serverError().entity("Bir hata olustu").build();
		}
		
	}
	@GET
	@Path(value = "/getbyidheader")
	@Produces(value = MediaType.APPLICATION_JSON)

	public Response getbyidheader(@HeaderParam(value = "id") long id)
	{
		// localhost:8080/JakartaEx/konu/getbyidheader
		try
		{
			Konu result = konu_repo.getByID(id);
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

}
