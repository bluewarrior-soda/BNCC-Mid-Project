import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Main 
{
	static Scanner scan = new Scanner(System.in);
	static ArrayList<String> kode_karyawan = new ArrayList<String>();
	static ArrayList<String> nama_karyawan = new ArrayList<String>();
	static ArrayList<String> jenis_kelamin_karyawan = new ArrayList<String>();
	static ArrayList<String> jabatan_karyawan = new ArrayList<String>();
	static ArrayList<String> gaji_karyawan = new ArrayList<String>();
	static ArrayList<String> kode_karyawan_bonus = new ArrayList<String>();
	
	public static void main(String[] args) 
	{
		menu();
	}

	public static void menu ()
	{
		System.out.println("Selamat datang di perusahaan PT.Mentol");
		System.out.println("=======================================");
		System.out.println("[1] Input data karyawan");
		System.out.println("[2] View data karyawan");
		System.out.println("[3] Update data karyawan");
		System.out.println("[4] Delete data karyawan");
		System.out.println("[0] Kembali");
		
		int pilihan;
		do
		{
			System.out.print(">> ");
			pilihan = scan.nextInt();
		} while (pilihan < 0 | pilihan > 4);
		
		switch (pilihan)
		{
		case 0:
			System.out.println("");
			System.out.println("Terima kasih telah menggunakan aplikasi perusahaan PT.Mentol :)");
			break;
		case 1:
			input(kode_karyawan, nama_karyawan, jenis_kelamin_karyawan, jabatan_karyawan, gaji_karyawan);
			break;
		case 2:
			view(kode_karyawan, nama_karyawan, jenis_kelamin_karyawan, jabatan_karyawan, gaji_karyawan);
			break;
		case 3:
			update(kode_karyawan, nama_karyawan, jenis_kelamin_karyawan, jabatan_karyawan, gaji_karyawan);
			break;
		default:
			delete(kode_karyawan, nama_karyawan, jenis_kelamin_karyawan, jabatan_karyawan, gaji_karyawan);
			break;
		}
	}
	
	public static String dapatkan_gaji_awal (String jabatan)
	{
		long gaji = 0;
		if (jabatan.equals("Manager"))
		{
			gaji = 8000000;
		}
		else if (jabatan.equals("Supervisor"))
		{
			gaji = 6000000;
		}
		else if (jabatan.equals("Admin"))
		{
			gaji = 4000000;
		}
		
		String GAJI = Long.toString(gaji);
		return GAJI;
	}
	
	public static void bonus_manager ()
	{
		System.out.print("Bonus sebesar 10 % telah diberikan kepada karyawan dengan ID : ");
		System.out.println(kode_karyawan_bonus.get(0) + " " + kode_karyawan_bonus.get(1) + " " + kode_karyawan_bonus.get(2));
	}
	
	public static void bonus_supervisor ()
	{
		System.out.print("Bonus sebesar 7.5 % telah diberikan kepada karyawan dengan ID : ");
		System.out.println(kode_karyawan_bonus.get(0) + " " + kode_karyawan_bonus.get(1) + " " + kode_karyawan_bonus.get(2));
	}
	
	public static void bonus_admin ()
	{
		System.out.print("Bonus sebesar 5 % telah diberikan kepada karyawan dengan ID : ");
		System.out.println(kode_karyawan_bonus.get(0) + " " + kode_karyawan_bonus.get(1) + " " + kode_karyawan_bonus.get(2));
	}
	
	public static void beri_bonus_gaji_dan_selamat (ArrayList<String> kode_karyawan, ArrayList<String> nama_karyawan, ArrayList<String> jenis_kelamin_karyawan, ArrayList<String> jabatan_karyawan, ArrayList<String> gaji_karyawan)
	{
		int jumlah_manager = 0, jumlah_supervisor = 0, jumlah_admin = 0;
		for (String jabatan : jabatan_karyawan)
		{
			if (jabatan.equals("Manager")) jumlah_manager++;
			else if (jabatan.equals("Supervisor")) jumlah_supervisor++;
			else if (jabatan.equals("Admin")) jumlah_admin++;
		}
		
		int manager = 0, supervisor = 0, admin = 0;
		if (jumlah_manager > 3)
		{
			for (int i = 0; i < kode_karyawan.size(); i++)
			{
				if (manager == 3) break;
				else if (jabatan_karyawan.get(i).equals("Manager"))
				{
					long gaji_manager_awal = Long.parseLong(gaji_karyawan.get(i));
					long gaji_manager_setelah_bonus = (110 * gaji_manager_awal) / 100;
					String gaji_manager = Long.toString(gaji_manager_setelah_bonus);
					gaji_karyawan.set(i, gaji_manager);
					kode_karyawan_bonus.add(kode_karyawan.get(i));
					manager++;
				}
			}
			
			bonus_manager();
			jumlah_manager = 0;
		}
		if (jumlah_supervisor > 3)
		{
			for (int i = 0; i < kode_karyawan.size(); i++)
			{
				if (supervisor == 3) break;
				else if (jabatan_karyawan.get(i).equals("Supervisor"))
				{
					long gaji_supervisor_awal = Long.parseLong(gaji_karyawan.get(i));
					long gaji_supervisor_setelah_bonus = (1075 * gaji_supervisor_awal) / 1000;
					String gaji_supervisor = Long.toString(gaji_supervisor_setelah_bonus);
					gaji_karyawan.set(i, gaji_supervisor);
					kode_karyawan_bonus.add(kode_karyawan.get(i));
					supervisor++;
				}
			}
			
			bonus_supervisor();
			jumlah_supervisor = 0;
		}
		if (jumlah_admin > 3)
		{
			for (int i = 0; i < kode_karyawan.size(); i++)
			{
				if (admin == 3) break;
				else if (jabatan_karyawan.get(i).equals("Admin"))
				{
					long gaji_admin_awal = Long.parseLong(gaji_karyawan.get(i));
					long gaji_admin_setelah_bonus = (105 * gaji_admin_awal) / 100;
					String gaji_admin = Long.toString(gaji_admin_setelah_bonus);
					kode_karyawan_bonus.add(kode_karyawan.get(i));
					gaji_karyawan.set(i, gaji_admin);
					admin++;
				}
			}
			
			bonus_admin();
			jumlah_admin = 0;
		}
		
		manager = 0;
		supervisor = 0;
		admin = 0;
		jumlah_manager = 0;
		jumlah_supervisor = 0;
		jumlah_admin = 0;
	}
	
	public static void beri_bonus_gaji_tanpa_selamat (ArrayList<String> kode_karyawan, ArrayList<String> nama_karyawan, ArrayList<String> jenis_kelamin_karyawan, ArrayList<String> jabatan_karyawan, ArrayList<String> gaji_karyawan)
	{
		int jumlah_manager = 0, jumlah_supervisor = 0, jumlah_admin = 0;
		for (String jabatan : jabatan_karyawan)
		{
			if (jabatan.equals("Manager")) jumlah_manager++;
			else if (jabatan.equals("Supervisor")) jumlah_supervisor++;
			else if (jabatan.equals("Admin")) jumlah_admin++;
		}
		
		int manager = 0, supervisor = 0, admin = 0;
		if (jumlah_manager > 3)
		{
			for (int i = 0; i < kode_karyawan.size(); i++)
			{
				if (manager == 3) break;
				else if (jabatan_karyawan.get(i).equals("Manager"))
				{
					long gaji_manager_awal = Long.parseLong(gaji_karyawan.get(i));
					long gaji_manager_setelah_bonus = (110 / 100) * gaji_manager_awal;
					String gaji_manager = Long.toString(gaji_manager_setelah_bonus);
					gaji_karyawan.set(i, gaji_manager);
					kode_karyawan_bonus.add(kode_karyawan.get(i));
					manager++;
				}
			}
			jumlah_manager = 0;
		}
		
		if (jumlah_supervisor > 3)
		{
			for (int i = 0; i < kode_karyawan.size(); i++)
			{
				if (supervisor == 3) break;
				else if (jabatan_karyawan.get(i).equals("Supervisor"))
				{
					long gaji_supervisor_awal = Long.parseLong(gaji_karyawan.get(i));
					long gaji_supervisor_setelah_bonus = (1075 / 1000) * gaji_supervisor_awal;
					String gaji_supervisor = Long.toString(gaji_supervisor_setelah_bonus);
					gaji_karyawan.set(i, gaji_supervisor);
					kode_karyawan_bonus.add(kode_karyawan.get(i));
					supervisor++;
				}
			}
			jumlah_supervisor = 0;
		}
		
		if (jumlah_admin > 3)
		{
			for (int i = 0; i < kode_karyawan.size(); i++)
			{
				if (admin == 3) break;
				else if (jabatan_karyawan.get(i).equals("Admin"))
				{
					long gaji_admin_awal = Long.parseLong(gaji_karyawan.get(i));
					long gaji_admin_setelah_bonus = (105 / 100) * gaji_admin_awal;
					String gaji_admin = Long.toString(gaji_admin_setelah_bonus);
					kode_karyawan_bonus.add(kode_karyawan.get(i));
					gaji_karyawan.set(i, gaji_admin);
					admin++;
				}
			}
			jumlah_admin = 0;
		}
		
		manager = 0;
		supervisor = 0;
		admin = 0;
		jumlah_manager = 0;
		jumlah_supervisor = 0;
		jumlah_admin = 0;
	}

	public static void input (ArrayList<String> kode_karyawan, ArrayList<String> nama_karyawan, ArrayList<String> jenis_kelamin_karyawan, ArrayList<String> jabatan_karyawan, ArrayList<String> gaji_karyawan)
	{
		System.out.println("Input nama karyawan [>= 3]: ");
		String nama = scan.nextLine();
		while (true)
		{
			if (nama.length() >= 3) break;
			else
			{
				System.out.println("Input nama karyawan [>= 3]: ");
				nama = scan.nextLine();
			}
		}
		nama_karyawan.add(nama);

		System.out.println("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
		String jenis_kelamin = scan.nextLine();
		while (true)
		{
			if (jenis_kelamin.equals("Laki-laki") | jenis_kelamin.equals("Perempuan"))
			{
				break;
			}
			else
			{
				System.out.println("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
				jenis_kelamin = scan.nextLine();
			}
		}
		jenis_kelamin_karyawan.add(jenis_kelamin);
		
		System.out.println("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
		String jabatan = scan.nextLine();
		while (true)
		{
			if (jabatan.equals("Manager") | jabatan.equals("Supervisor") | jabatan.equals("Admin"))
			{
				break;
			}
			else
			{
				System.out.println("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
				jabatan = scan.nextLine();
			}
		}
		jabatan_karyawan.add(jabatan);
		
		String gaji;
		if (jabatan.equals("Manager"))
		{
			gaji = dapatkan_gaji_awal("Manager");
		}
		else if (jabatan.equals("Supervisor"))
		{
			gaji = dapatkan_gaji_awal("Supervisor");
		}
		else
		{
			gaji = dapatkan_gaji_awal("Admin");
		}
		gaji_karyawan.add(gaji);
		
		Random random = new Random();
		int huruf_1 = random.nextInt(26) + 65;
		int huruf_2 = random.nextInt(26) + 65;
		char huruf_pertama = (char) huruf_1;
		char huruf_kedua = (char) huruf_2;
		
		int kode_angka = random.nextInt(9000) + 1000;
		
		String kode = Character.toString(huruf_pertama) + Character.toString(huruf_kedua) + "-" + kode_angka;
		kode_karyawan.add(kode);
		
		System.out.println("Berhasil menambahkan karyawan dengan ID : " + kode);
		beri_bonus_gaji_dan_selamat(kode_karyawan, nama_karyawan, jenis_kelamin_karyawan, jabatan_karyawan, gaji_karyawan);
		
		System.out.println("Tekan ENTER untuk kembali");
		scan.nextLine();
		menu();
	}
	
	public static void view (ArrayList<String> kode_karyawan, ArrayList<String> nama_karyawan, ArrayList<String> jenis_kelamin_karyawan, ArrayList<String> jabatan_karyawan, ArrayList<String> gaji_karyawan)
	{
		beri_bonus_gaji_tanpa_selamat(kode_karyawan, nama_karyawan, jenis_kelamin_karyawan, jabatan_karyawan, gaji_karyawan);
		
		System.out.println("|==================================================================================================|");
		System.out.println("| No. |   Kode Karyawan   |   Nama Karyawan   | Jenis Kelamin |  Jabatan Karyawan  | Gaji Karyawan |");
		System.out.println("|==================================================================================================|");
		
		for (int i = 0; i < nama_karyawan.size(); i++)
		{
			System.out.print("|    " + (i + 1) + "|");
			
			for (int j = 0; j < 19 - kode_karyawan.get(i).length(); j++)
			{
				System.out.print(" ");
			}
			System.out.print(kode_karyawan.get(i) + "|");
			
			for (int j = 0; j < 19 - nama_karyawan.get(i).length(); j++)
			{
				System.out.print(" ");
			}
			System.out.print(nama_karyawan.get(i) + "|");
			
			for (int j = 0; j < 15 - jenis_kelamin_karyawan.get(i).length(); j++)
			{
				System.out.print(" ");
			}
			System.out.print(jenis_kelamin_karyawan.get(i) + "|");
			
			for (int j = 0; j < 20 - jabatan_karyawan.get(i).length(); j++)
			{
				System.out.print(" ");
			}
			System.out.print(jabatan_karyawan.get(i) + "|");
			
			for (int j = 0; j < 12 - gaji_karyawan.get(i).length(); j++)
			{
				System.out.print(" ");
			}
			System.out.println("Rp." + gaji_karyawan.get(i) + "|");
		}
		System.out.println("|==================================================================================================|");
		menu();
	}
	
	public static void update (ArrayList<String> kode_karyawan, ArrayList<String> nama_karyawan, ArrayList<String> jenis_kelamin_karyawan, ArrayList<String> jabatan_karyawan, ArrayList<String> gaji_karyawan)
	{
		view_tanpa_kembali_ke_menu(kode_karyawan, nama_karyawan, jenis_kelamin_karyawan, jabatan_karyawan, gaji_karyawan);
		
		System.out.println("Input nomor karyawan yang ingin di-update [0 untuk kembali] : ");
		int nomor = scan.nextInt();
		
		if (nomor == 0)
		{
			menu();
		}
		
		System.out.println("Input nama karyawan [>= 3]: ");
		String nama = scan.nextLine();
		while (true)
		{
			if (nama.length() >= 3) break;
			else
			{
				System.out.println("Input nama karyawan [>= 3]: ");
				nama = scan.nextLine();
			}
		}

		nama_karyawan.set(nomor - 1, nama);
		System.out.println("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
		String jenis_kelamin = scan.nextLine();
		while (true)
		{
			if (jenis_kelamin.equals("Laki-laki") | jenis_kelamin.equals("Perempuan"))
			{
				break;
			}
			else
			{
				System.out.println("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
				jenis_kelamin = scan.nextLine();
			}
		}
		jenis_kelamin_karyawan.set(nomor - 1, jenis_kelamin);
		
		System.out.println("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
		String jabatan = scan.nextLine();
		while (true)
		{
			if (jabatan.equals("Manager") | jabatan.equals("Supervisor") | jabatan.equals("Admin"))
			{
				break;
			}
			else
			{
				System.out.println("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
				jabatan = scan.nextLine();
			}
		}
		jabatan_karyawan.set(nomor - 1, jabatan);
		
		String gaji;
		if (jabatan.equals("Manager"))
		{
			gaji = dapatkan_gaji_awal("Manager");
		}
		else if (jabatan.equals("Supervisor"))
		{
			gaji = dapatkan_gaji_awal("Supervisor");
		}
		else
		{
			gaji = dapatkan_gaji_awal("Admin");
		}
		gaji_karyawan.set(nomor - 1, gaji);
		
		Random random = new Random();
		int huruf_1 = random.nextInt(26) + 65;
		int huruf_2 = random.nextInt(26) + 65;
		char huruf_pertama = (char) huruf_1;
		char huruf_kedua = (char) huruf_2;
		
		int kode_angka = random.nextInt(9000) + 1000;
		
		String kode = Character.toString(huruf_pertama) + Character.toString(huruf_kedua) + "-" + kode_angka;
		kode_karyawan.set(nomor - 1, kode);
		
		System.out.println("Berhasil mengupdate karyawan dengan ID baru : " + kode);
		
		System.out.println("Tekan ENTER untuk kembali");
		scan.nextLine();
		menu();
	}
	
	public static void view_tanpa_kembali_ke_menu (ArrayList<String> kode_karyawan, ArrayList<String> nama_karyawan, ArrayList<String> jenis_kelamin_karyawan, ArrayList<String> jabatan_karyawan, ArrayList<String> gaji_karyawan)
	{
		System.out.println("|==================================================================================================|");
		System.out.println("| No. |   Kode Karyawan   |   Nama Karyawan   | Jenis Kelamin |  Jabatan Karyawan  | Gaji Karyawan |");
		System.out.println("|==================================================================================================|");
		
		for (int i = 0; i < nama_karyawan.size(); i++)
		{
			System.out.print("|    " + (i + 1) + "|");
			
			for (int j = 0; j < 19 - kode_karyawan.get(i).length(); j++)
			{
				System.out.print(" ");
			}
			System.out.print(kode_karyawan.get(i) + "|");
			
			for (int j = 0; j < 19 - nama_karyawan.get(i).length(); j++)
			{
				System.out.print(" ");
			}
			System.out.print(nama_karyawan.get(i) + "|");
			
			for (int j = 0; j < 15 - jenis_kelamin_karyawan.get(i).length(); j++)
			{
				System.out.print(" ");
			}
			System.out.print(jenis_kelamin_karyawan.get(i) + "|");
			
			for (int j = 0; j < 20 - jabatan_karyawan.get(i).length(); j++)
			{
				System.out.print(" ");
			}
			System.out.print(jabatan_karyawan.get(i) + "|");
			
			for (int j = 0; j < 12 - gaji_karyawan.get(i).length(); j++)
			{
				System.out.print(" ");
			}
			System.out.println("Rp." + gaji_karyawan.get(i) + "|");
		}
		System.out.println("|==================================================================================================|");
	}
	
	public static void delete (ArrayList<String> kode_karyawan, ArrayList<String> nama_karyawan, ArrayList<String> jenis_kelamin_karyawan, ArrayList<String> jabatan_karyawan, ArrayList<String> gaji_karyawan)
	{
		view_tanpa_kembali_ke_menu(kode_karyawan, nama_karyawan, jenis_kelamin_karyawan, jabatan_karyawan, gaji_karyawan);
		
		System.out.println("Input nomor karyawan yang ingin di-delete [0 untuk kembali] : ");
		int nomor = scan.nextInt();
		if (nomor == 0)
		{
			menu();
		}
		kode_karyawan.remove(nomor - 1);
		nama_karyawan.remove(nomor - 1);
		jenis_kelamin_karyawan.remove(nomor - 1);
		jabatan_karyawan.remove(nomor - 1);
		gaji_karyawan.remove(nomor - 1);
		
		System.out.println("Tekan ENTER untuk kembali");
		scan.nextLine();
		menu();
	}
}