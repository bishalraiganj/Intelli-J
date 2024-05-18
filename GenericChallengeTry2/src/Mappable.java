public interface Mappable {

    String render();
    static Double[] stringToLatlon(String latLon)
    {
        var l=latLon.split(",");
        var lat=Double.valueOf(l[0]);
        var lon=Double.valueOf(l[1]);
        return new Double[] {lat,lon};
    }
}
