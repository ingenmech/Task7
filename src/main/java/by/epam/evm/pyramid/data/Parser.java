package by.epam.evm.pyramid.data;

public interface Parser {
    <T> T parse(String data);
}
