package pres;

public class Map1 {
    def map1[T, U](ch: Source[T], f: T => U): Source[U] =
    val out = Channel[U]()
            Thread.ofVirtual().start(() => {
        while(true) {
            ch.receive() match
            case t: T                   => out.send(f(t)); true
            case ChannelClosed.Done     => out.done();     false
            case ChannelClosed.Error(e) => out.error(e);   false
        }
    })
    out

    void map<T, U>(Source<T> c, )
}
