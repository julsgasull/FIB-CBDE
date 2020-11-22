package wineinfo.data_model;

import java.util.Random;

import wineinfo.avro.WineInfo;

public class Generator {
			
	public static String nextValue(int min, int max, Random rand) {
		double value = (rand.nextInt((max-min)*1000000)+min*1000000)/(double)1000000;
		return String.valueOf(value);
	}
	
	public static String nextType(Random rand) {
		int type = rand.nextInt(3)+1;
		if (type == 1) {
			return "type_1";
		}
		else if (type == 2) {
			return "type_2";
		}
		else if (type == 3) {
			return "type_3";
		}
		return "type_NA";
	}
	
	public static String nextRegion(String type, Random rand) {
		if (type.equals("type_1")) {
			return String.valueOf(rand.nextInt(10));
		}
		else if (type.equals("type_2")) {
			return String.valueOf(rand.nextInt(10*10));
		}
		else if (type.equals("type_3")) {
			return String.valueOf(rand.nextInt(10*10*10));
		}
		return "region_NA";
	}
	
	private static final String[] names = new String[] {
			"alc",					// Alchol
			"m_acid",				// Malic Acid
			"ash",					// Ash
			"alc_ash",				// Alcalinity of ash
			"mgn",					// Magnesium
			"t_phenols",			// Total phenols
			"flav",					// Flavanoids
			"nonflav_phenols",		// Nonflavanoid phenols
			"proant",				// Proanthocyanins
			"col",					// Color intensity
			"hue",					// Hue
			"od280/od315",			// OD280/OD315 of diluted wines
			"proline"				// Proline
		};
		
		private static final int[][] intervals = new int[][] {
			new int[] {10, 15},
			new int[] {1, 5},
			new int[] {2, 3},
			new int[] {15, 30},
			new int[] {50, 150},
			new int[] {0, 5},
			new int[] {0, 1},
			new int[] {1, 5},
			new int[] {0, 1},
			new int[] {0, 5},
			new int[] {0, 2},
			new int[] {1, 4},
			new int[] {100, 2000}
		};
		
		public static WineInfo generateNewInstance(long seed) {
			Random rand = new Random(seed);
			WineInfo w = new WineInfo();
			w.setType(nextType(rand));
			w.setRegion(Integer.parseInt(Generator.nextRegion(w.getType().toString(),rand)));
			for (int j = 0; j < intervals.length; j++) {
				switch (j) {
					case 0: {
						w.setAlc(Double.parseDouble(nextValue(intervals[j][0], intervals[j][1],rand))); break;
					}
					case 1: {
						w.setMAcid(Double.parseDouble(nextValue(intervals[j][0], intervals[j][1],rand))); break;
					}
					case 2: {
						w.setAsh(Double.parseDouble(nextValue(intervals[j][0], intervals[j][1],rand))); break;
					}
					case 3: {
						w.setAlcAsh(Double.parseDouble(nextValue(intervals[j][0], intervals[j][1],rand))); break;
					}
					case 4: {
						w.setMgn(Double.parseDouble(nextValue(intervals[j][0], intervals[j][1],rand))); break;
					}
					case 5: {
						w.setTPhenols(Double.parseDouble(nextValue(intervals[j][0], intervals[j][1],rand))); break;
					}
					case 6: {
						w.setFlav(Double.parseDouble(nextValue(intervals[j][0], intervals[j][1],rand))); break;
					}
					case 7: {
						w.setNonflavPhenols(Double.parseDouble(nextValue(intervals[j][0], intervals[j][1],rand))); break;
					}
					case 8: {
						w.setProant(Double.parseDouble(nextValue(intervals[j][0], intervals[j][1],rand))); break;
					}
					case 9: {
						w.setCol(Double.parseDouble(nextValue(intervals[j][0], intervals[j][1],rand))); break;
					}
					case 10: {
						w.setHue(Double.parseDouble(nextValue(intervals[j][0], intervals[j][1],rand))); break;
					}
					case 11: {
						w.setOd280od315(Double.parseDouble(nextValue(intervals[j][0], intervals[j][1],rand))); break;
					}
					case 12: {
					    w.setProline(Double.parseDouble(nextValue(intervals[j][0], intervals[j][1],rand))); break;
					}
				}
			}
			return w;
		}
	
	
}
