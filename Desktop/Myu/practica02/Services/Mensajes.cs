using System;
using System.ServiceModel;

namespace WSDL.mensajes // El html sería el contrato donde estan expuestas las operaciones
{
    [ServiceContract]
    public interface Mensajes
    {
        [OperationContract]
        string Saludar(string nombre);
        [OperationContract]
        string Mostrar(int id);
    }
}