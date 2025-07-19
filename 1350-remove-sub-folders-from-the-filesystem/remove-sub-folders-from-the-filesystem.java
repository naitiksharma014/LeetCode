class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> list = new ArrayList<>();
        int n = folder.length;
        Set<String> folderSet = new HashSet<>(Arrays.asList(folder));

        for( String currStr : folder ){
            boolean isSubFolder = false;
            String temp = currStr;

            while( !currStr.isEmpty() ){
                int pos = currStr.lastIndexOf( '/' );

                if( pos == -1 ) break;

                currStr = currStr.substring( 0 , pos );

                if( folderSet.contains(currStr) ){
                    isSubFolder = true;
                    break;
                }
            }

            if( !isSubFolder ){
                list.add( temp );
            }
        }
        return list;
    }
}