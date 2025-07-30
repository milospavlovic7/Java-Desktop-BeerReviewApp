package transfer.util;

/**
 * Interface defining operation constants for various actions
 * related to Korisnik, Pivara, Pivo, Recenzija, and OmiljenoPivo.
 */
public interface Operation {

    // Korisnik operations
    public static final int LOGIN_KORISNIK = 0;
    public static final int REGISTER_KORISNIK = 1;
    public static final int UPDATE_KORISNIK = 2;
    public static final int DELETE_KORISNIK = 3;
    public static final int GET_ALL_KORISNIK = 4;

    // Pivara operations
    public static final int LOGIN_PIVARA = 10;
    public static final int REGISTER_PIVARA = 11;
    public static final int UPDATE_PIVARA = 13;
    public static final int DELETE_PIVARA = 14;
    public static final int GET_ALL_PIVARA = 15;

    // Pivo operations
    public static final int ADD_PIVO = 20;
    public static final int UPDATE_PIVO = 21;
    public static final int DELETE_PIVO = 22;
    public static final int GET_ALL_PIVO = 23;
    public static final int GET_ALL_PIVO_ZA_PIVARU = 24;

    // Recenzija operations
    public static final int ADD_RECENZIJA = 30;
    public static final int UPDATE_RECENZIJA = 31;
    public static final int DELETE_RECENZIJA = 32;
    public static final int GET_ALL_RECENZIJA = 33;
    public static final int GET_RECENZIJE_ZA_PIVO = 34;

    // Omiljena piva operations
    public static final int ADD_OMILJENO_PIVO = 40;
    public static final int DELETE_OMILJENO_PIVO = 41;
    public static final int GET_ALL_OMILJENO_PIVO_ZA_KORISNIKA = 42;
}
