package modele;

import java.util.*;
import java.util.stream.Collectors;

public class Panier {
    private static final float FRAIS_LIVRAISON = 4.5f;

    private final Set<PanierListener> listeners = new HashSet<>();
    private final Map<Tomate, Integer> articles = new HashMap<>();
    private Coordonnées coordonnées;

    private static EntreeArticle mapEntryToEntreeArticle(Map.Entry<Tomate, Integer> entry) {
        return new EntreeArticle(entry.getKey(), entry.getValue(), entry.getKey().getPrixTTC() * entry.getValue());
    }

    public void ajouterArticle(Tomate tomate, int quantité) {
        if (articles.containsKey(tomate)) {
            articles.put(tomate, articles.get(tomate) + quantité);
        } else {
            articles.put(tomate, quantité);
        }
        notifyAllListeners();
    }

    public void modifierQuantitéArticle(Tomate tomate, int quantité) {
        if (quantité == 0) {
            articles.remove(tomate);
        } else {
            articles.put(tomate, quantité);
        }
        notifyAllListeners();
    }

    public List<EntreeArticle> getArticles() {
        return articles.entrySet().stream().map(Panier::mapEntryToEntreeArticle).collect(Collectors.toList());
    }

    public int getQuantité(Tomate tomate) {
        return articles.getOrDefault(tomate, 0);
    }

    public void vider() {
        articles.clear();
        notifyAllListeners();
    }

    public float sousTotal() {
        float sousTotal = 0;
        for (Tomate tomate : articles.keySet()) {
            sousTotal += tomate.getPrixTTC() * articles.get(tomate);
        }
        return sousTotal;
    }

    public float fraisDeLivraison() {
        return FRAIS_LIVRAISON;
    }

    public float prixTotal() {
        return articles.isEmpty() ? 0 : sousTotal() + fraisDeLivraison();
    }

    public void addPanierListener(PanierListener listener) {
        listeners.add(listener);
    }

    public void removePanierListener(PanierListener listener) {
        listeners.remove(listener);
    }

    private void notifyAllListeners() {
        for (PanierListener listener : listeners) {
            listener.onPanierChanged();
        }
    }

    public Coordonnées getCoordonnées() {
        return coordonnées;
    }

    public void setCoordonnées(Coordonnées coordonnées) {
        this.coordonnées = coordonnées;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("COORDONNÉES CLIENT :\n");
        builder.append("\tNom :                  ").append(getCoordonnées().nom).append('\n');
        builder.append("\tPrénom :               ").append(getCoordonnées().prénom).append('\n');
        builder.append("\tAdresse :              ").append(getCoordonnées().adresse1).append('\n');
        builder.append("\tComplément d'adresse : ").append(getCoordonnées().adresse2).append('\n');
        builder.append("\tCode postal :          ").append(getCoordonnées().codePostal).append('\n');
        builder.append("\tVille :                ").append(getCoordonnées().ville).append('\n');
        builder.append("\tTéléphone :            ").append(getCoordonnées().téléphone).append('\n');
        builder.append("\tMail :                 ").append(getCoordonnées().mail).append('\n');
        builder.append("\n\n");
        builder.append("DÉTAILS DE LA COMMANDE :\n");
        for (EntreeArticle article : getArticles()) {
            builder.append(" - ");
            builder.append(article.tomate.getDésignation()).append("; ");
            builder.append("quantité : ").append(article.getQuantité()).append("; ");
            builder.append("sous-total : ").append(article.total).append('€');
            builder.append('\n');
        }
        builder.append('\n');
        builder.append("      Coût commande : ").append(sousTotal()).append("€\n");
        builder.append(" Frais de livraison : ").append(fraisDeLivraison()).append("€\n");
        builder.append("          Total TTC : ").append(sousTotal()).append("€\n");
        return builder.toString();
    }

    public interface PanierListener {
        void onPanierChanged();
    }

    public static class EntreeArticle {
        private final Tomate tomate;
        private final int quantité;
        private final float total;

        EntreeArticle(Tomate tomate, int quantité, float total) {
            this.tomate = tomate;
            this.quantité = quantité;
            this.total = total;
        }

        public Tomate getTomate() {
            return tomate;
        }

        public int getQuantité() {
            return quantité;
        }

        public float getTotal() {
            return total;
        }
    }

    public static class Coordonnées {
        private final String nom;
        private final String prénom;
        private final String adresse1;
        private final String adresse2;
        private final String codePostal;
        private final String ville;
        private final String téléphone;
        private final String mail;

        public Coordonnées(
                String nom,
                String prénom,
                String adresse1,
                String adresse2,
                String codePostal,
                String ville,
                String téléphone,
                String mail
        ) {
            this.nom = nom;
            this.prénom = prénom;
            this.adresse1 = adresse1;
            this.adresse2 = adresse2;
            this.codePostal = codePostal;
            this.ville = ville;
            this.téléphone = téléphone;
            this.mail = mail;
        }
    }
}
