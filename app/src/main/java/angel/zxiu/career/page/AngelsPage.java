package angel.zxiu.career.page;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import angel.zxiu.career.R;
import angel.zxiu.career.block.AngelsBlock;

/**
 * Created by zxiu on 15.07.16.
 */
public abstract class AngelsPage extends FrameLayout {


    ListView listView;
    AngelsBlockListAdapter adapter = new AngelsBlockListAdapter();

    List<View> editableViews = new ArrayList<>();

    public AngelsPage(Context context) {
        super(context);
        inflate(context, R.layout.angels_page, this);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        addDefaultBlock();
//        inflate(context, getLayoutResId(), this);
//        traverseViews(this);
    }

    public void addBlock(AngelsBlock block) {
        adapter.addBlock(block);
    }

    public void addDefaultBlock(){
        addBlock(getDefaultBlock());
    }

    public abstract int getTitleResId();

    public abstract AngelsBlock getDefaultBlock();

    void traverseViews(final View view) {
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                traverseViews(((ViewGroup) view).getChildAt(i));
            }
        } else if (view instanceof EditText) {
            editableViews.add(view);
        }
    }

    class AngelsBlockListAdapter extends BaseAdapter {
        List<AngelsBlock> blockList = new ArrayList<>();

        public void addBlock(AngelsBlock block) {
            blockList.add(block);
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return blockList.size();
        }

        @Override
        public AngelsBlock getItem(int i) {
            return blockList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            return getItem(i);
        }
    }
}
