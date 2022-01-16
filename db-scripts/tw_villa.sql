CREATE TABLE IF NOT EXISTS tw_villa (
    WORLD           VARCHAR(10) NOT NULL,
    NAME_VILLA      VARCHAR(100) NOT NULL,
    X               INTEGER NOT NULL,
    Y               INTEGER NOT NULL,
    ID_VILLA        VARCHAR(10) NOT NULL,
    TYPE_VILLA      VARCHAR(5) NOT NULL,
    WL              INTEGER NOT NULL,
    SP              INTEGER NOT NULL,
    SW              INTEGER NOT NULL,
    AX              INTEGER NOT NULL,
    AR              INTEGER NOT NULL,
    SU              INTEGER NOT NULL,
    LC              INTEGER NOT NULL,
    MA              INTEGER NOT NULL,
    HC              INTEGER NOT NULL,
    RM              INTEGER NOT NULL,
    CT              INTEGER NOT NULL,
    PD              INTEGER NOT NULL,
    NB              INTEGER NOT NULL,
    FARM            VARCHAR(25) NOT NULL,

    CRE_TS          TIMESTAMPTZ NOT NULL,

    PRIMARY KEY (WORLD, X, Y, CRE_TS)
);