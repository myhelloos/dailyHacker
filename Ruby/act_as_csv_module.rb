module ActAsCsv

    def self.included(base)
        base.extend ClassMethods
    end

    module ClassMethods
        def act_as_csv
            include InstanceMethods
        end
    end

    module InstanceMethods

        def read
            @csv_contents = []
            filename = self.class.to_s.downcase + '.txt'
            file = File.new(filename)
            @headers = file.gets.chomp.split(',').each {|item| item.strip!}

            file.each do |row|
                @csv_contents << row.chomp.split(',').each {|item| item.strip!}
            end
        end

        def each(&block)
            @csv_contents.each { |row| block.call(CsvRow.new(@headers, row)) }
        end

        attr_accessor :headers, :csv_contents

        def initialize
            read
        end
    end

end

class CsvRow
    def initialize(headers, row)
        @headers = headers
        @data = row
    end

    attr_accessor :headers, :data

    def method_missing name, *args
        h = name.to_s
        @data[@headers.index(h)]
    end
end

class RubyCsv
    include ActAsCsv
    act_as_csv

end

m =  RubyCsv.new
# puts m.headers.inspect
# puts m.csv_contents.inspect

m.each {|row| puts row.ID }
