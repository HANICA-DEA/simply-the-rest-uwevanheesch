package nl.han.dea;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/customers")
public class CustomerResource {

    private CustomerService customerService = CustomerService.getInstance();

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getAllCustomersAsText() {
        StringBuffer customers = new StringBuffer();
        customerService.getAllCustomers().stream().forEach(customerDTO -> {
            customers.append(customerDTO.getName() + ", ");
        });
        return Response.ok(customers.toString()).build();
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCustomersAsJSON() {
        List customerList = customerService.getAllCustomers();
        return Response.ok(customerList).build();
    }

    @GET
    @Path("/{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomerByID(@PathParam("customerId") Integer customerID) {
        return Response.ok(customerService.getCustomer(customerID)).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCustomer(CustomerDTO customer) {
        System.out.println("CustomerName" + customer.getName());
        customerService.addCustomer(customer);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/{customerId}")
    public Response deleteCustomer(@PathParam("customerId") Integer customerId) {
        customerService.deleteCustomer(customerId);
        return Response.status(Response.Status.OK).build();
    }


}
