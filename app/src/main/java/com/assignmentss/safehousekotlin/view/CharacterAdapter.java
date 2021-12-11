package com.assignmentss.safehousekotlin.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.assignmentss.safehousekotlin.data.remote.model.CharacterItem;
import com.assignmentss.safehousekotlin.utils.CommonMethods;
import com.assignmentss.safehousekotlin.R;
import com.assignmentss.safehousekotlin.databinding.ItemCharacterBinding;

import java.util.List;


public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterVH> {
    private final Context context;
    private final List<CharacterItem> characterItems;
    private final LayoutInflater inflater;


    public CharacterAdapter(Context context, List<CharacterItem> CharacterItems) {
        this.context = context;
        this.characterItems = CharacterItems;
        inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CharacterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CharacterVH(inflater.inflate(R.layout.item_character,parent));
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterVH holder, int position) {
        CommonMethods.loadImage(holder.getItemCharacterBinding().imageView, characterItems.get(position).img);
        holder.getItemCharacterBinding().getRoot().setOnLongClickListener(v -> {
            CommonMethods.showShortToast(context, characterItems.get(position).getNameOccupation());
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return characterItems.size();
    }

    public static class CharacterVH extends RecyclerView.ViewHolder{
        private View view;
        public CharacterVH(@NonNull View view) {
            super(view);
            setItemCharacterBinding(view);
        }

        public ItemCharacterBinding getItemCharacterBinding() {
            return ItemCharacterBinding.bind(view);
        }

        public void setItemCharacterBinding(View view) {
            this.view = view;
        }
    }
}
