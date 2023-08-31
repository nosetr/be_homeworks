package com.nosetr._202308_30.enums;

public enum Currency {
	USD {
		@Override
		public String getSymbolString() { return "$"; }

		@Override
		public double getConvert() { return 0.85; }
	},
	EUR {
		@Override
		public String getSymbolString() { return "€"; }

		@Override
		public double getConvert() { return 1.12; }
	},
	GBP {
		@Override
		public String getSymbolString() { return "£"; }

		@Override
		public double getConvert() { return 1.43; }
	};

	public abstract String getSymbolString();

	public abstract double getConvert();

//	USD("$"), EUR("€"), GBP("£");
//	
//	private final String symbolString;
//
//	Currency(String symbolString) {
//		this.symbolString = symbolString;
//	}
//	
//	public String getSymbolString() {
//		return this.symbolString;
//	}

}
