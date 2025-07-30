package thread;

import controller.ServerController;
import domain.*;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ThreadClient extends Thread {

    private Socket socket;

    public ThreadClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Request request = (Request) in.readObject();
                Response response = handleRequest(request);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Response handleRequest(Request request) {
        Response response = new Response(null, null, ResponseStatus.SUCCESS);
        try {
            switch (request.getOperation()) {

                // Korisnik operations
                case Operation.LOGIN_KORISNIK:
                    response.setData(ServerController.getInstance().loginKorisnik((Korisnik) request.getData()));
                    break;
                case Operation.REGISTER_KORISNIK:
                    response.setData(ServerController.getInstance().registerKorisnik((Korisnik) request.getData()));
                    break;
                case Operation.UPDATE_KORISNIK:
                    response.setData(ServerController.getInstance().updateKorisnik((Korisnik) request.getData()));
                    break;
                case Operation.DELETE_KORISNIK:
                    ServerController.getInstance().deleteKorisnik((Korisnik) request.getData());
                    break;
                case Operation.GET_ALL_KORISNIK:
                    response.setData(ServerController.getInstance().getAllKorisnik());
                    break;

                // Pivara operations
                case Operation.LOGIN_PIVARA:
                    response.setData(ServerController.getInstance().loginPivara((Pivara) request.getData()));
                    break;
                case Operation.REGISTER_PIVARA:
                    response.setData(ServerController.getInstance().registerPivara((Pivara) request.getData()));
                    break;
                case Operation.UPDATE_PIVARA:
                    response.setData(ServerController.getInstance().updatePivara((Pivara) request.getData()));
                    break;
                case Operation.DELETE_PIVARA:
                    ServerController.getInstance().deletePivara((Pivara) request.getData());
                    break;
                case Operation.GET_ALL_PIVARA:
                    response.setData(ServerController.getInstance().getAllPivara());
                    break;

                // Pivo operations
                case Operation.ADD_PIVO:
                    response.setData(ServerController.getInstance().addPivo((Pivo) request.getData()));
                    break;
                case Operation.UPDATE_PIVO:
                    response.setData(ServerController.getInstance().updatePivo((Pivo) request.getData()));
                    break;
                case Operation.DELETE_PIVO:
                    ServerController.getInstance().deletePivo((Pivo) request.getData());
                    break;
                case Operation.GET_ALL_PIVO_ZA_PIVARU:
                    response.setData(ServerController.getInstance().getAllPivoZaPivaru((Pivara) request.getData()));
                    break;
                case Operation.GET_ALL_PIVO:
                    response.setData(ServerController.getInstance().getAllPivo());
                    break;

                // Recenzija operations
                case Operation.ADD_RECENZIJA:
                    response.setData(ServerController.getInstance().addRecenzija((Recenzija) request.getData()));
                    break;
                case Operation.UPDATE_RECENZIJA:
                    response.setData(ServerController.getInstance().updateRecenzija((Recenzija) request.getData()));
                    break;
                case Operation.DELETE_RECENZIJA:
                    ServerController.getInstance().deleteRecenzija((Recenzija) request.getData());
                    break;
                case Operation.GET_RECENZIJE_ZA_PIVO:
                    response.setData(ServerController.getInstance().getAllZaPivoRecenzija((Pivo) request.getData()));
                    break;
                case Operation.GET_ALL_RECENZIJA:
                    response.setData(ServerController.getInstance().getAllRecenzija());
                    break;

                // Omiljeno pivo operations
                case Operation.ADD_OMILJENO_PIVO:
                    response.setData(ServerController.getInstance().addOmiljenoPivo((OmiljenoPivo) request.getData()));
                    break;
                case Operation.DELETE_OMILJENO_PIVO:
                    ServerController.getInstance().deleteOmiljenoPivo((OmiljenoPivo) request.getData());
                    break;
                case Operation.GET_ALL_OMILJENO_PIVO_ZA_KORISNIKA:
                    response.setData(ServerController.getInstance().getAllOmiljenoPivoZaKorisnika((OmiljenoPivo) request.getData()));
                    break;

                default:
                    response.setResponseStatus(ResponseStatus.ERROR);
                    response.setException(new Exception("Nepoznata operacija."));
                    break;
            }
        } catch (Exception e) {
            response.setResponseStatus(ResponseStatus.ERROR);
            response.setException(e);
        }
        return response;
    }
}
