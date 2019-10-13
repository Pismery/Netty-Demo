namespace java org.pismery.demo.netty.thrift.generate
namespace py py.thrift.generate


typedef i16 short
typedef i32 int
typedef i64 long
typedef bool boolean
typedef string String


enum RequestType {
    GET = 0,
    POST = 1,
    PUT = 2,
    DELETE = 3,
}

enum ResponseType {
    SUCCESS = 0,
    FAILURE = -1,
}


struct Request {
	1: optional RequestType requestType,
	2: optional String msg,
}


struct Response {
    1: optional ResponseType responseType,
	2: optional String msg,
	3: optional String result,
}

exception DataException {
    1: optional String msg,
    2: optional String callStack,
    3: optional String date,
}

service ThriftService {
    Response ping(1: required Request request) throws (1: DataException dataException)
}



