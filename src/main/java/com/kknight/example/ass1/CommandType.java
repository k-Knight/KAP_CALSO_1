package com.kknight.example.ass1;

public enum CommandType {
    undefined {
        @Override
        public String toString() {
            return "udf";
        }
    },
    add {
        @Override
        public String toString() {
            return "add";
        }
    },
    remove {
        @Override
        public String toString() {
            return "rem";
        }
    },
    clear {
        @Override
        public String toString() {
            return "clr";
        }
    },
    print {
        @Override
        public String toString() {
            return "prt";
        }
    }
}
