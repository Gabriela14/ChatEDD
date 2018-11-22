
package librerias;

public class LibSobreChat implements java.io.Serializable{
    
    

    /**
     * * Un encabezado de este tipo significa que es un mensaje de control no válido.
     */    
    public static final int INVALID_MSG = 0;
    
    /**
     * Un encabezado de este tipo significa que es un mensaje de conexión que proviene de un chat.
     * cliente.
     */    
    public static final int CONNECT_MSG = 1;    
    
    /**
     * Un encabezado de este tipo significa que el servidor de chat reconocerá la conexión.
     * intento desde el cliente de chat.
     */        
    public static final int CONNECT_MSG_ACK = 10;

    /**
     * Un encabezado de este tipo significa que el nombre de usuario ya está siendo usado por otro
     * usuario del cliente de chat.
     */      
    public static final int CONNECT_MSG_NACK = 100;

    /**
     *Un encabezado de este tipo significa que un usuario de chat está dispuesto a desconectarse de
     * El servidor de chat.

     */      
    public static final int DISCONNECT_MSG = 2;

    /**
    * Un encabezado de este tipo significa que el servidor de chat reconocerá la desconexión
     * Mensaje del usuario del cliente de chat.
     */      
    public static final int DISCONNECT_MSG_ACK = 20;
    
    /**
     * Un encabezado de este tipo significa que es un mensaje de chat regular de un cliente de chat
     * y debe ser enviado a todos los usuarios conectados.

     */      
    public static final int CHAT_MSG = 3;

    /**
     *Un encabezado de este tipo significa que el servidor de chat está enviando un mensaje a todos los conectados
     * Usuarios de clientes de chat.
     */      
    public static final int SERVERBROADCAST_MSG = 4;

    /**
     * Un encabezado de este tipo significa que el usuario del cliente de chat es el primero en conectarse
     * al servidor de chat.

     */  
    public static final int HOMEALONE_MSG = 5;

    /**
     * Un encabezado de este tipo significa que una solicitud para actualizar la lista de usuarios
     * ha sido enviado.
     */  
    public static final int UPDTLISTOFUSERS_MSG = 6;

    /**
     * Un encabezado de este tipo significa que un nuevo usuario cliente se ha unido a la sala de chat.
     */      
    public static final int JOINING_MSG = 7;

    /**
     * Un encabezado de este tipo significa que el servidor de chat está desactivado.
     */  
    public static final int SERVERGOINGDOWN_MSG = 8;

    /**
     * A header of this type means the chat client acknowledges the server going
     * down message.
     */  
    public static final int SERVERGOINGDOWN_MSG_ACK = 80;

    /**
     * A header of this type means a chat client user has abandoned the chat room.
     */  
    public static final int ABANDON_MSG = 9;
    
    //MEMBER ATTRIBUTES

    /**
     * An integer representing the control header of the chat envelope.
     */
    private int envHeader;

    /**
     * A string representing the sender of the chat envelope.
     */
    private String envFrom;

    /**
     * A string representing the body of the chat envelope.
     */
    private String envBody;

    /**
     * A {@link ChatListaUsuario} type of object having a list of users.
     */
    private ChatListaUsuario envList;
    
    /**
     * constructor predeterminado de la clase chatEnvelope.
     * 
     */
    public LibSobreChat(int eHeader, String eFrom, String eBody, ChatListaUsuario eList){
        this.envHeader = eHeader;
        this.envFrom = eFrom;
        this.envBody = eBody;
        this.envList = eList;
    }
    
    /**
     * Another constructor for the chatEnvelope class.  It takes no parameters and
     * sets all its member attributes to its default values.
     */
    public LibSobreChat(){
        this.envHeader = 0;
        this.envFrom = "";
        this.envBody = "";
        this.envList = null;
    }    

    /**
     * The setEnvHeader method sets the value of the control header member attribute
     * for the chat envelope.
     * @param envHeader An integer representing a control message header for the
     * chat envelope.
     */
    public void setEnvHeader(int envHeader) {
        this.envHeader = envHeader;
    }

    /**
     * The setEnvFrom method sets the value of the sender member attribute of 
     * the chat envelope.
     * @param envFrom A string representing the sender for the chat envelope.
     */
    public void setEnvFrom(String envFrom) {
        this.envFrom = envFrom;
    }    

    /**
     * The setEnvBody method sets the value of the body member attribute of the 
     * chat envelope.
     * @param envBody A string representing the body for the chat envelope.
     */
    public void setEnvBody(String envBody) {
        this.envBody = envBody;
    }
    
    /**
     * The setEnvList method sets the value of the list of users member attribute 
     * of the chat envelope.
     * @param envList A {@link ChatListaUsuario} object representing a list of users
     * for the chat envelope.
     */
    public synchronized void setEnvList(ChatListaUsuario envList){
        this.envList = envList;
    }

    /**
     * The getEnvHeader method returns the value of the control message header
     * of the chat envelope.
     * @return An integer representing a control header message of the chat
     * envelope.
     */
    public int getEnvHeader() {
        return envHeader;
    }

    /**
     * The getEnvFrom method returns the value of the sender of the chat envelope.
     * @return A string representing the sender of the chat envelope.
     */
    public String getEnvFrom() {
        return envFrom;
    }

    /**
     * The getEnvBody method returns the value of the body of the chat envelope.
     * @return A string representing the body of the chat envelope.
     */
    public String getEnvBody() {
        return envBody;
    }
    
    /**
     * The getEnvUsersList return the list of users set in the chat envelope.
     * @return A {@link ChatListaUsuario} object representing a list of users of the
     * chat envelope.
     */
    public synchronized ChatListaUsuario getEnvUsersList(){
        return envList;
    }
    
    /**
     * The resetEnvelope method resets the value of the member attributes of the
     * chat envelope to its default values.
     */
    public void resetEnvelope(){
        this.setEnvHeader(0);
        this.setEnvFrom("");
        this.setEnvBody("");
        this.envList = null;
    }
    
}
