package com.utn.dds.javaianos.parser;

/* ExpressionParser.java */
 /* Generated By:JavaCC: Do not edit this line. ExpressionParser.java */
import java.io.InputStream;

public class ExpressionParser implements ExpressionParserConstants {

    public static boolean validate(InputStream stream) throws ParseException, TokenMgrError, NullPointerException {
        try {
            ExpressionParser parser = new ExpressionParser(stream);
            parser.evaluate();
            System.out.println("La expresion ha sido ingresada correctamente.");
            return true;
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error, la expresion ingresada es incorrecta.");
            return false;
        } catch (TokenMgrError ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error, uno de los caracteres ingresados no es valido.");
            return false;
        }
    }

    /**
     * * Parser Specification **
     */
    final public void evaluate() throws ParseException {
        expresion();
        jj_consume_token(0);
    }

    final public void expresion() throws ParseException {
        termino();
        label_1:
        while (true) {
            switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
                case SUMA:
                case RESTA: {
                    ;
                    break;
                }
                default:
                    jj_la1[0] = jj_gen;
                    break label_1;
            }
            switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
                case SUMA: {
                    jj_consume_token(SUMA);
                    termino();
                    break;
                }
                case RESTA: {
                    jj_consume_token(RESTA);
                    termino();
                    break;
                }
                default:
                    jj_la1[1] = jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
            }
        }
    }

    final public void termino() throws ParseException {
        factor();
        label_2:
        while (true) {
            switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
                case MULTIPLICACION:
                case DIVISION: {
                    ;
                    break;
                }
                default:
                    jj_la1[2] = jj_gen;
                    break label_2;
            }
            switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
                case MULTIPLICACION: {
                    jj_consume_token(MULTIPLICACION);
                    factor();
                    break;
                }
                case DIVISION: {
                    jj_consume_token(DIVISION);
                    factor();
                    break;
                }
                default:
                    jj_la1[3] = jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
            }
        }
    }

    final public void factor() throws ParseException {
        switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
            case NUMERO: {
                jj_consume_token(NUMERO);
                break;
            }
            case IDENTIFICADOR: {
                jj_consume_token(IDENTIFICADOR);
                break;
            }
            case PARENTESIS_IZQUIERDO: {
                jj_consume_token(PARENTESIS_IZQUIERDO);
                expresion();
                jj_consume_token(PARENTESIS_DERECHO);
                break;
            }
            default:
                jj_la1[4] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    /**
     * Generated Token Manager.
     */
    public ExpressionParserTokenManager token_source;
    SimpleCharStream jj_input_stream;
    /**
     * Current token.
     */
    public Token token;
    /**
     * Next token.
     */
    public Token jj_nt;
    private int jj_ntk;
    private int jj_gen;
    final private int[] jj_la1 = new int[5];
    static private int[] jj_la1_0;

    static {
        jj_la1_init_0();
    }

    private static void jj_la1_init_0() {
        jj_la1_0 = new int[]{0x180, 0x180, 0x600, 0x600, 0xa800,};
    }

    /**
     * Constructor with InputStream.
     */
    public ExpressionParser(java.io.InputStream stream) {
        this(stream, null);
    }

    /**
     * Constructor with InputStream and supplied encoding
     */
    public ExpressionParser(java.io.InputStream stream, String encoding) {
        try {
            jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1);
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        token_source = new ExpressionParserTokenManager(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 5; i++) {
            jj_la1[i] = -1;
        }
    }

    /**
     * Reinitialise.
     */
    public void ReInit(java.io.InputStream stream) {
        ReInit(stream, null);
    }

    /**
     * Reinitialise.
     */
    public void ReInit(java.io.InputStream stream, String encoding) {
        try {
            jj_input_stream.ReInit(stream, encoding, 1, 1);
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        token_source.ReInit(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 5; i++) {
            jj_la1[i] = -1;
        }
    }

    /**
     * Constructor.
     */
    public ExpressionParser(java.io.Reader stream) {
        jj_input_stream = new SimpleCharStream(stream, 1, 1);
        token_source = new ExpressionParserTokenManager(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 5; i++) {
            jj_la1[i] = -1;
        }
    }

    /**
     * Reinitialise.
     */
    public void ReInit(java.io.Reader stream) {
        jj_input_stream.ReInit(stream, 1, 1);
        token_source.ReInit(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 5; i++) {
            jj_la1[i] = -1;
        }
    }

    /**
     * Constructor with generated Token Manager.
     */
    public ExpressionParser(ExpressionParserTokenManager tm) {
        token_source = tm;
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 5; i++) {
            jj_la1[i] = -1;
        }
    }

    /**
     * Reinitialise.
     */
    public void ReInit(ExpressionParserTokenManager tm) {
        token_source = tm;
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 5; i++) {
            jj_la1[i] = -1;
        }
    }

    private Token jj_consume_token(int kind) throws ParseException {
        Token oldToken;
        if ((oldToken = token).next != null) {
            token = token.next;
        } else {
            token = token.next = token_source.getNextToken();
        }
        jj_ntk = -1;
        if (token.kind == kind) {
            jj_gen++;
            return token;
        }
        token = oldToken;
        jj_kind = kind;
        throw generateParseException();
    }

    /**
     * Get the next Token.
     */
    final public Token getNextToken() {
        if (token.next != null) {
            token = token.next;
        } else {
            token = token.next = token_source.getNextToken();
        }
        jj_ntk = -1;
        jj_gen++;
        return token;
    }

    /**
     * Get the specific Token.
     */
    final public Token getToken(int index) {
        Token t = token;
        for (int i = 0; i < index; i++) {
            if (t.next != null) {
                t = t.next;
            } else {
                t = t.next = token_source.getNextToken();
            }
        }
        return t;
    }

    private int jj_ntk_f() {
        if ((jj_nt = token.next) == null) {
            return (jj_ntk = (token.next = token_source.getNextToken()).kind);
        } else {
            return (jj_ntk = jj_nt.kind);
        }
    }

    private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
    private int[] jj_expentry;
    private int jj_kind = -1;

    /**
     * Generate ParseException.
     */
    public ParseException generateParseException() {
        jj_expentries.clear();
        boolean[] la1tokens = new boolean[17];
        if (jj_kind >= 0) {
            la1tokens[jj_kind] = true;
            jj_kind = -1;
        }
        for (int i = 0; i < 5; i++) {
            if (jj_la1[i] == jj_gen) {
                for (int j = 0; j < 32; j++) {
                    if ((jj_la1_0[i] & (1 << j)) != 0) {
                        la1tokens[j] = true;
                    }
                }
            }
        }
        for (int i = 0; i < 17; i++) {
            if (la1tokens[i]) {
                jj_expentry = new int[1];
                jj_expentry[0] = i;
                jj_expentries.add(jj_expentry);
            }
        }
        int[][] exptokseq = new int[jj_expentries.size()][];
        for (int i = 0; i < jj_expentries.size(); i++) {
            exptokseq[i] = jj_expentries.get(i);
        }
        return new ParseException(token, exptokseq, tokenImage);
    }

    /**
     * Enable tracing.
     */
    final public void enable_tracing() {
    }

    /**
     * Disable tracing.
     */
    final public void disable_tracing() {
    }

}
