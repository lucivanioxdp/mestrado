package com.valores.app.model;

public enum TipoPeriodo {
    SEMANAL{
        @Override
        public String toString(){
            return "SEMANAL";
        }
    },
    QUINZENAL{
        @Override
        public String toString(){
            return "QUINZENAL";
        }
    },
    MENSAL{
        @Override
        public String toString(){
            return "MENSAL";
        }
    },
    BIMESTRAL{
        @Override
        public String toString(){
            return "BIMESTRAL";
        }
    },
    QUADRIMESTRAL{
        @Override
        public String toString(){
            return "QUADRIMESTRAL";
        }
    },
    SEMESTRAL{
        @Override
        public String toString(){
            return "SEMESTRAL";
        }
    }
}
