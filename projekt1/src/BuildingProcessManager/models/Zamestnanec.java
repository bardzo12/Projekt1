package BuildingProcessManager.models;

import java.util.Date;
import java.util.Set;


public class Zamestnanec {
	
	private Integer id;
	
	private Post Post;
	
	private String Meno;
	
	private String Priezvisko;
	
	private Boolean Zdravotny_stav;
	
	private Date ZaciatokPN;
	
	private Date KoniecPN;
	
	private Boolean Maliar=false;
	
	private Boolean Murar=false;
	
	private Boolean Obkladac=false;
	
	private Boolean Betonar=false;
	
	private Boolean Klampiar=false;
	
	private Boolean Vodic_bager=false;
	
	private Boolean Vodic_nakladne=false;
	
	private Boolean Architekt=false;
	
	private String Telefon;
	
	private Set<Etapa> etapy;
	
	private Adresa Adresa;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Post getPost() {
		return Post;
	}

	public void setPost(Post Post) {
		this.Post = Post;
	}

	public String getMeno() {
		return Meno;
	}

	public void setMeno(String meno) {
		Meno = meno;
	}

	public String getPriezvisko() {
		return Priezvisko;
	}

	public void setPriezvisko(String priezvisko) {
		Priezvisko = priezvisko;
	}

	public Boolean getZdravotny_stav() {
		return Zdravotny_stav;
	}

	public void setZdravotny_stav(Boolean zdravotny_stav) {
		Zdravotny_stav = zdravotny_stav;
	}

	public String getTelefon() {
		return Telefon;
	}

	public void setTelefon(String telefon) {
		Telefon = telefon;
	}

	public Set<Etapa> getEtapy() {
		return etapy;
	}

	public void setEtapy(Set<Etapa> etapy) {
		this.etapy = etapy;
	}

	public Adresa getAdresa() {
		return Adresa;
	}

	public void setAdresa(Adresa adresa) {
		Adresa = adresa;
	}
	
	public Boolean getMaliar() {
		return Maliar;
	}

	public void setMaliar(Boolean maliar) {
		Maliar = maliar;
	}

	public Boolean getMurar() {
		return Murar;
	}

	public void setMurar(Boolean murar) {
		Murar = murar;
	}

	public Boolean getObkladac() {
		return Obkladac;
	}

	public void setObkladac(Boolean obkladac) {
		Obkladac = obkladac;
	}

	public Boolean getBetonar() {
		return Betonar;
	}

	public void setBetonar(Boolean betonar) {
		Betonar = betonar;
	}

	public Boolean getKlampiar() {
		return Klampiar;
	}

	public void setKlampiar(Boolean klampiar) {
		Klampiar = klampiar;
	}

	public Boolean getArchitekt() {
		return Architekt;
	}

	public void setArchitekt(Boolean architekt) {
		Architekt = architekt;
	}

	public Boolean getVodic_bager() {
		return Vodic_bager;
	}

	public void setVodic_bager(Boolean vodic_bager) {
		Vodic_bager = vodic_bager;
	}

	public Boolean getVodic_nakladne() {
		return Vodic_nakladne;
	}

	public void setVodic_nakladne(Boolean vodic_nakladne) {
		Vodic_nakladne = vodic_nakladne;
	}

	public Date getZaciatokPN() {
		return ZaciatokPN;
	}

	public void setZaciatokPN(Date zaciatokPN) {
		ZaciatokPN = zaciatokPN;
	}

	public Date getKoniecPN() {
		return KoniecPN;
	}

	public void setKoniecPN(Date koniecPN) {
		KoniecPN = koniecPN;
	}

	public Zamestnanec(Integer Id, String Meno, String Priezvisko, Boolean Zdravotny_stav, String Number, Adresa Adresa, Post Post, Boolean Maliar, Boolean Murar, Boolean Obkladac, Boolean Betonar, Boolean Klampiar, Boolean Vodic_bager, Boolean Vodic_nakladne, Boolean Architekt, Date ZaciatokPN, Date KoniecPN){
		setId(Id);
		setMeno(Meno);
		setPriezvisko(Priezvisko);
		setZdravotny_stav(Zdravotny_stav);
		setTelefon(Number);
		//Adresa Adresa = new Adresa(Hous_Number, Ulica, Mesto, PSC);
		setPost(Post);
		setAdresa(Adresa);
		setZaciatokPN(ZaciatokPN);
		setKoniecPN(KoniecPN);
		setMaliar(Maliar);
		setMurar(Murar);
		setObkladac(Obkladac);
		setBetonar(Betonar);
		setKlampiar(Klampiar);
		setVodic_bager(Vodic_bager);
		setVodic_nakladne(Vodic_nakladne);
		setArchitekt(Architekt);
	}

	public Zamestnanec() {
		// TODO Auto-generated constructor stub
	}
}
